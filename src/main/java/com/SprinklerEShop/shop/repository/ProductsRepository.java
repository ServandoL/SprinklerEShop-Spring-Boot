package com.SprinklerEShop.shop.repository;

import com.SprinklerEShop.shop.models.products.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductsRepository extends MongoRepository<Product, String> {
    @Query("{ category: '?0', isDeleted: false }")
    Page<Product> findByCategory(String category, Pageable pageable);

}
