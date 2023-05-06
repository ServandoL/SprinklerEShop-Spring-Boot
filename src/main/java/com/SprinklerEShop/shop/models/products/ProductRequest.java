package com.SprinklerEShop.shop.models.products;

import org.springframework.data.domain.Pageable;

public class ProductRequest {
    private String category;
    private Pageable pageable;
    public ProductRequest(String category, Pageable pageable) {
        this.category = category;
        this.pageable = pageable;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }
}
