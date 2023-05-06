package com.SprinklerEShop.shop.models.products;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Objects;

@Document("PRODUCTS")
public class Product {
    @Id
    private String id;
    private String productName;
    private double price;
    private String category;
    private String brand;
    private int stock;
    private String imageUrl;
    private String modifiedBy;
    private String modifiedDate;
    private String productId;
    private String lastModifiedDate;
    @BsonProperty(value = "deleted_by")
    private String deletedBy;
    @BsonProperty(value = "deleted_date")
    private String deletedDate;
    private ArrayList<Rating> ratings;
    private ArrayList<ModifiedBy> modified;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", stock=" + stock +
                ", imageUrl='" + imageUrl + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", productId='" + productId + '\'' +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                ", deletedBy='" + deletedBy + '\'' +
                ", deletedDate='" + deletedDate + '\'' +
                ", ratings=" + ratings +
                ", modified=" + modified +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.getPrice(), getPrice()) == 0 && getStock() == product.getStock() && Objects.equals(getId(), product.getId()) && Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getCategory(), product.getCategory()) && Objects.equals(getBrand(), product.getBrand()) && Objects.equals(getImageUrl(), product.getImageUrl()) && Objects.equals(getModifiedBy(), product.getModifiedBy()) && Objects.equals(getModifiedDate(), product.getModifiedDate()) && Objects.equals(getProductId(), product.getProductId()) && Objects.equals(getLastModifiedDate(), product.getLastModifiedDate()) && Objects.equals(getDeletedBy(), product.getDeletedBy()) && Objects.equals(getDeletedDate(), product.getDeletedDate()) && Objects.equals(getRatings(), product.getRatings()) && Objects.equals(getModified(), product.getModified());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductName(), getPrice(), getCategory(), getBrand(), getStock(), getImageUrl(), getModifiedBy(), getModifiedDate(), getProductId(), getLastModifiedDate(), getDeletedBy(), getDeletedDate(), getRatings(), getModified());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    public ArrayList<ModifiedBy> getModified() {
        return modified;
    }

    public void setModified(ArrayList<ModifiedBy> modified) {
        this.modified = modified;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }
}
