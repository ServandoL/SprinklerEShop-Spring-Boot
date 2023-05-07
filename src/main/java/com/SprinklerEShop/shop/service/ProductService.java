package com.SprinklerEShop.shop.service;

import com.SprinklerEShop.shop.models.products.FilteredProductRequest;
import com.SprinklerEShop.shop.models.products.Product;
import com.SprinklerEShop.shop.models.products.ProductRequest;
import com.SprinklerEShop.shop.repository.ProductsRepository;
import com.mongodb.MongoClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    ProductsRepository productRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public Page<Product> getFilteredProducts(FilteredProductRequest request, Pageable pageable) {
        Query query = new Query();
        query.with(pageable);
        if (request.getCategory() != null && request.getCategory().size() > 0) {
            if (request.getCategory().size() == 1) {
                query.addCriteria(Criteria.where("category").is(request.getCategory().get(0)));
            } else {
                query.addCriteria(Criteria.where("category").in(request.getCategory()));
            }
        }
        if (request.getBrand() != null && request.getBrand().size() > 0) {
            if (request.getBrand().size() == 1) {
                query.addCriteria(Criteria.where("brand").is(request.getBrand().get(0)));
            } else {
                query.addCriteria(Criteria.where("brand").in(request.getBrand()));
            }
        }
        if (request.getPriceRange() != null && request.getPriceRange().size() > 0) {

            if (request.getPriceRange().size() == 1) {
                query.addCriteria(Criteria.where("price").lte(request.getPriceRange().get(0)));
            } else if (request.getPriceRange().get(0) != null && request.getPriceRange().get(1) != null) {
                query.addCriteria(Criteria.where("price").gte(request.getPriceRange().get(0)).lte(request.getPriceRange().get(1)));
            }
        }
        if (request.getSearch() != null) {
            query.addCriteria(Criteria.where("productName").regex(request.getSearch()));
        }
        if (request.getRating() != null) {
            query.addCriteria(Criteria.where("rating").gte(request.getRating()).lte(request.getRating() + 1));
        }
        try {
            return PageableExecutionUtils.getPage(
                    mongoTemplate.find(query, Product.class),
                    pageable,
                    () -> mongoTemplate.count(query.skip(0).limit(0), Product.class)
            );
        } catch (MongoClientException e) {
            throw new MongoClientException("An error occurred trying to fetch the products");
        }

    }

    public Page<Product> getProducts(ProductRequest request) {
        try {
            return productRepository.findByCategory(request.getCategory(), request.getPageable());
        } catch (MongoClientException e) {
            throw new MongoClientException("An error occurred trying to fetch the products.");
        }
    }

    public Optional<Product> getProductById(String id) {
        if (id == null) {
            throw new NullPointerException("Id cannot be null");
        }
        try {
            return productRepository.findById(id);
        } catch (MongoClientException e) {
            throw new MongoClientException("An error occurred trying to fetch the products.");
        }
    }

    public Map<String, List<String>> getProductFilters() {
        GroupOperation groupByCategory = Aggregation.group("category");
        GroupOperation groupByBrand = Aggregation.group("brand");
        Aggregation categoryAgg = Aggregation.newAggregation(groupByCategory);
        Aggregation brandAgg = Aggregation.newAggregation(groupByBrand);

        HashSet<String> category;
        HashSet<String> brand;
        Map<String, List<String>> result = new HashMap<>();
        AggregationResults<Product> categoryOutput = mongoTemplate.aggregate(categoryAgg, "PRODUCTS", Product.class);
        AggregationResults<Product> brandOutput = mongoTemplate.aggregate(brandAgg, "PRODUCTS", Product.class);
        if (categoryOutput.getMappedResults().size() > 0) {

            category = new HashSet<String>(categoryOutput.getMappedResults().stream().map(Product::getId).toList());
            result.put("category", category.stream().toList());
        }
        if (brandOutput.getMappedResults().size() > 0) {
            brand = new HashSet<String>(brandOutput.getMappedResults().stream().map(Product::getId).toList());
            result.put("brand", brand.stream().toList());
        }
        return result;
    }

}
