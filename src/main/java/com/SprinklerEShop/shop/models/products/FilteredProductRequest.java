package com.SprinklerEShop.shop.models.products;

import java.util.List;
import java.util.Objects;

public class FilteredProductRequest {
    private List<String> brand;
    private List<String> category;
    private List<Integer> priceRange;
    private String search;
    private Integer rating;


    @Override
    public String toString() {
        return "FilteredProductRequest{" +
                "brand=" + brand +
                ", category=" + category +
                ", priceRange=" + priceRange +
                ", search='" + search + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilteredProductRequest that = (FilteredProductRequest) o;
        return Objects.equals(getBrand(), that.getBrand()) && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getPriceRange(), that.getPriceRange()) && Objects.equals(getSearch(), that.getSearch()) && Objects.equals(getRating(), that.getRating());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getCategory(), getPriceRange(), getSearch(), getRating());
    }

    public List<String> getBrand() {
        return brand;
    }

    public void setBrand(List<String> brand) {
        this.brand = brand;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<Integer> getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(List<Integer> priceRange) {
        this.priceRange = priceRange;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
