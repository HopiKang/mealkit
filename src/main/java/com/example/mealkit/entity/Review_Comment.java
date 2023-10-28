package com.example.mealkit.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Review_Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nickname;
    @Column(unique = true)
    private String review_comment;
    @Column
    private Date review_date;
}
