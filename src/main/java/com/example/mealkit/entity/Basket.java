package com.example.mealkit.entity;

import jakarta.persistence.*;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nickname;
    @Column(unique = true)
    private String article_id;

}
