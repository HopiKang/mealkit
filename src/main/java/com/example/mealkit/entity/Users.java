package com.example.mealkit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 생성
@ToString
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 생성
@Getter
/**
 * UserEntity
 * 회원가입된 유저의 순번, 이름, 아이디, 비밀번호, 생성날짜를 저장
 * 순번은 pk, userId 는 unique 로 설정
 */
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성
    private Long id; // 순번

    @Column(unique = true)
    private String nickname; // 이름

    @Column(name = "user_id",unique = true)
    private String userId; // 아이디

    @Column(name = "user_password")
    private String userPassword; // 비밀번호

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate; // 생성날짜

    public void patch(Users users){
        this.nickname = nickname;
        this.userId = userId;
        this.userPassword = userPassword;
    }
}
