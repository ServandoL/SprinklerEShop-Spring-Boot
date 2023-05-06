package com.SprinklerEShop.shop.controllers;

import com.SprinklerEShop.shop.api.products.ProductApi;
import com.SprinklerEShop.shop.models.products.Product;
import com.SprinklerEShop.shop.models.products.ProductRequest;
import com.SprinklerEShop.shop.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController implements ProductApi {
    @Resource
    private ProductService productService;

    @Override
    public ResponseEntity<Page<Product>> getProducts(String category, Pageable pageable) {
        ProductRequest request = new ProductRequest(category, pageable);
        Page<Product> response = productService.getProducts(request);
        return new ResponseEntity<Page<Product>>(response, HttpStatus.OK);
    }
}
