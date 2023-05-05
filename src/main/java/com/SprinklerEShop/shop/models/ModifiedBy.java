package com.SprinklerEShop.shop.models;

import java.util.Objects;

public class ModifiedBy {
    private String productId;
    private String modifiedBy;
    private String modifiedDate;
    private String productName;
    private double price;
    private int stock;
    private String imageUrl;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ModifiedBy{" +
                "productId='" + productId + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModifiedBy that = (ModifiedBy) o;
        return Double.compare(that.getPrice(), getPrice()) == 0 && getStock() == that.getStock() && Objects.equals(getProductId(), that.getProductId()) && Objects.equals(getModifiedBy(), that.getModifiedBy()) && Objects.equals(getModifiedDate(), that.getModifiedDate()) && Objects.equals(getProductName(), that.getProductName()) && Objects.equals(getImageUrl(), that.getImageUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getModifiedBy(), getModifiedDate(), getProductName(), getPrice(), getStock(), getImageUrl());
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
