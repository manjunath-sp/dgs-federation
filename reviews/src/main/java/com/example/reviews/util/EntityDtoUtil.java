package com.example.reviews.util;

import com.example.reviews.entity.Review;
import com.example.reviews.dto.ReviewDto;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static ReviewDto toDto(Review review) {
        ReviewDto dto = new ReviewDto();
        BeanUtils.copyProperties(review, dto);
        return dto;
    }

    public static Review toEntity(ReviewDto dto) {
        Review review = new Review();
        BeanUtils.copyProperties(dto, review);
        return review;
    }

}
