package com.SprinklerEShop.shop.controllers;

import com.SprinklerEShop.shop.api.products.ProductApi;
import com.SprinklerEShop.shop.models.products.FilteredProductRequest;
import com.SprinklerEShop.shop.models.products.Product;
import com.SprinklerEShop.shop.models.products.ProductRequest;
import com.SprinklerEShop.shop.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Override
    public ResponseEntity<Optional<Product>> getProductById(String id) {
        Optional<Product> response = productService.getProductById(id);
        return new ResponseEntity<Optional<Product>>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, List<String>>> getFilters() {
        Map<String, List<String>> response = productService.getProductFilters();
        return new ResponseEntity<Map<String, List<String>>>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<Product>> findProducts(FilteredProductRequest request, Pageable pageable) {
        Page<Product> response = productService.getFilteredProducts(request, pageable);
        return new ResponseEntity<Page<Product>>(response, HttpStatus.OK);
    }


}
