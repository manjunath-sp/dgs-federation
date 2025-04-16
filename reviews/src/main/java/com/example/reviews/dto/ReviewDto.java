package com.example.reviews.dto;

import com.example.generated.reviews.types.Review;

public class ReviewDto extends Review {

    @Override
    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String id;


    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }

    public String listing;

}
