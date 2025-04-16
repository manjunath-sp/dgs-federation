package com.example.reviews.repository;

import com.example.reviews.dto.ReviewDto;
import com.example.reviews.entity.Review;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReviewRepository extends ReactiveCrudRepository<Review, Integer> {

    @Query("SELECT * FROM reviews")
    Flux<ReviewDto> findAllReviews();
    @Query("SELECT * FROM reviews WHERE listing = :listingId")
    Flux<ReviewDto> findByListingId(String listingId);

    @Query("SELECT AVG(rating) FROM reviews WHERE listing = :listingId")
    Mono<Float> findRatingsByListingId(String listingId);
}
