package com.example.reviews.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table("reviews")
public class Review {

    @Id
    private Integer id;
    private String text;
    private double rating;
    private String listing;
}
