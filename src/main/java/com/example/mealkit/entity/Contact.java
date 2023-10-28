package com.example.mealkit.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nickname;
    @Column(unique = true)
    private String contact;
    @Column
    private Date contact_date;
}
