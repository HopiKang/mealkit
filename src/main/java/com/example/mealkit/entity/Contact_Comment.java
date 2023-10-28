package com.example.mealkit.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Contact_Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nickname;
    @Column
    private String contact_comment;
    @Column
    private Date contact_comment_date;
}
