package com.example.mealkit.repository;

import com.example.mealkit.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.ArrayList;
import java.util.List;


/**
 * UserRepository
 * Crud 를 상속하며 Users Long 타입을 받아옴
 * */
public interface UsersRepository extends JpaRepository<Users, Long> {
//    findAll 로 Users 모두조회
    @Override
    ArrayList<Users> findAll();

//    @Query(value = "update Users set nickname = :nickname, userId = :userId, )


    @Query(value = "update Users set nickname = :nickname, userId = :userId", nativeQuery = true)
    List<Users> findbyNicknameAndUserId(String nickname, String userId);
//    select * from Users WHERE nickname = :nickname

}
