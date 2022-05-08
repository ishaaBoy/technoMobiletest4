package com.example.technomobiletest4;

public class Review {
    String name;
    String review;
    int Rating;

    public String getName() {
        return name;
    }



    public int getRating() {
        return Rating;
    }

    public String getReview() {
        return review;
    }
    public Review() {

    }
    public Review(String review) {
        this.review = review;
    }
}
