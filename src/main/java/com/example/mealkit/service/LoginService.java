package com.example.mealkit.service;

import com.example.mealkit.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class LoginService {

    @Autowired
    private UsersRepository usersRepository;
    public String login(){

    }
}
