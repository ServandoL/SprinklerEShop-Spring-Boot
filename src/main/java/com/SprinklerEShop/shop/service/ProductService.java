package com.SprinklerEShop.shop.service;

import com.SprinklerEShop.shop.models.products.Product;
import com.SprinklerEShop.shop.models.products.ProductRequest;
import com.SprinklerEShop.shop.repository.ProductsRepository;
import com.mongodb.MongoClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductsRepository productRepository;

    public Page<Product> getProducts(ProductRequest request) {
        if (request.getPageable() != null) {
            try {
                return productRepository.findByCategory(request.getCategory(), request.getPageable());
            } catch (MongoClientException e) {
                throw new MongoClientException("An error occurred trying to fetch the products.");
            }
        } else {
            try {
                return productRepository.findAll(request.getPageable());
            } catch (MongoClientException e) {
                throw new MongoClientException("An error occurred trying to fetch the products.");
            }
        }
    }

}
