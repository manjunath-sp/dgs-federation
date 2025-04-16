package com.example.reviews.datafetchers;

import com.example.generated.reviews.types.Listing;
import com.example.reviews.dto.ReviewDto;
import com.example.reviews.service.ReviewService;
import com.netflix.graphql.dgs.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RequiredArgsConstructor
@DgsComponent
public class ReviewsDataFetcher {

  private final ReviewService reviewService;


  @DgsQuery
  public Flux<ReviewDto> allReviews() {
    return this.reviewService.all();
  }

  @DgsEntityFetcher(name = "Listing")
  public Listing resolveListingReference(Map<String, Object> entityRepresentation) {
    Listing listing = new Listing();
    String id = (String) entityRepresentation.get("id");
    listing.setId(id);
    return listing;
  }

  @DgsData(parentType = "Listing")
  public Flux<ReviewDto> reviews(DgsDataFetchingEnvironment dfe) {
    Listing listing = dfe.getSource();
    assert listing != null;
    String id = listing.getId();
    return this.reviewService.findByListingId(id);
  }

  @DgsData(parentType = "Listing")
  public Mono<Float> overallRating(DgsDataFetchingEnvironment dfe) {
    Listing listing = dfe.getSource();
    String id = listing.getId();
    return this.reviewService.findRatingsByListingId(id);
  }
}
