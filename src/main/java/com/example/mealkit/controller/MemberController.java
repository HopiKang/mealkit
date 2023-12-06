package com.example.mealkit.controller;

import com.example.mealkit.dto.MemberDto;
import com.example.mealkit.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
//    생성자 주입
    private final MemberService memberService;


//    회원가입 페이지 출력
    @GetMapping("/member/save")
    public String saveForm(){
        return "home/save";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDto memberDto){
        System.out.println("MemberController.save");
        System.out.println("memberDto = " + memberDto);
        memberService.save(memberDto);
        return "home/login";
    }

    @GetMapping("/member/login")
    public String loginForm(){
        return "home/login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDto memberDto, HttpSession session){
        MemberDto loginResult = memberService.login(memberDto);
        System.out.println(loginResult.getMemberEmail());
        if (loginResult != null){
            session.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "home/main";
        } else {
            return "home/login";
        }
    }
}
