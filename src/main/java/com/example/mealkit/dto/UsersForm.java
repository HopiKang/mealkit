package com.example.mealkit.dto;

import com.example.mealkit.entity.Users;
import lombok.*;

import java.sql.Date;

/**
 * User Dto
 * ViewLayer 와 DBLayer 의 역할을 나눔
 * Client, Controller, Service, Repository 사이에 사용됨
 * 그렇기 때문에 사이사이 사용될때 생성자생성으로 리셋해준다
 * 회원가입된유저의 이름, 아이디, 비밀번호를 조회 수정 할수있게한다
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsersForm {
    private String nickname;
    private String userId;
    private String userPassword;
    private Date createdDate;

    /**
 * toEntity 메서드
 * DTO 의 필요한 부분을 Entity 로 만든다
 */
    public Users toEntity(){
        return new Users(null, nickname, userId, userPassword, createdDate);
    }
}
