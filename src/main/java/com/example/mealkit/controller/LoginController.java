package com.example.mealkit.controller;

import com.example.mealkit.service.LoginService;
import com.example.mealkit.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login(HttpSession session){
//
//        session.setAttribute();
        return "login/login";
    }



    @GetMapping()
    public String logout(HttpServlet request){
        return "";
    }




}
