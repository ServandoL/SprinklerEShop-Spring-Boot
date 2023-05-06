package com.SprinklerEShop.shop.api.products;

import com.SprinklerEShop.shop.models.products.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/v1/products")
public interface ProductApi {
    @GetMapping(produces = {"application/json"})
    ResponseEntity<Page<Product>> getProducts(
            @RequestParam(required = false) String category,
            @PageableDefault(size = 8, sort = {"_id"}) Pageable pageable
    );
}
