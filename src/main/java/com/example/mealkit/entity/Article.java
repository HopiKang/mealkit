package com.example.mealkit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Article(항목)
 * id 고유값
 * article_name 제품이름
 * article_id 제품코드
 */
@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String article_name;
    @Column(unique = true)
    private String article_id;

}
