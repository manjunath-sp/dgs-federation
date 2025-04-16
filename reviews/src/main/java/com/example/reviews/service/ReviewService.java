package com.example.reviews.service;

import com.example.reviews.dto.ReviewDto;
import com.example.reviews.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Flux<ReviewDto> all() {
        return this.reviewRepository.findAllReviews();
    }

    public Flux<ReviewDto> findByListingId(String listingId) {
        return this.reviewRepository.findByListingId(listingId);
    }

    public Mono<Float> findRatingsByListingId(String listingId) {
        return this.reviewRepository.findRatingsByListingId(listingId);
    }

}
