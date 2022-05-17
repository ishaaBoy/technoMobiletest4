package com.example.technomobiletest4;

public class ChekingD {

    String brand;
    String model;
    String price;
    String promotionType;
    String discountPrice;
    String description;

    public ChekingD(String brand, String model, String price, String promotionType, String discountPrice, String description) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.promotionType = promotionType;
        this.discountPrice = discountPrice;
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

