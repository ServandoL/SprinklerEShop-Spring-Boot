package com.SprinklerEShop.shop.models;

import java.util.Objects;

public class Rating {
    private String name;
    private String review;
    private int rate;

    @Override
    public String toString() {
        return "Rating{" +
                "name='" + name + '\'' +
                ", review='" + review + '\'' +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return getRate() == rating.getRate() && Objects.equals(getName(), rating.getName()) && Objects.equals(getReview(), rating.getReview());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getReview(), getRate());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
