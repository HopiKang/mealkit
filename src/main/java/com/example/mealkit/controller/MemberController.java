package com.example.mealkit.controller;

import com.example.mealkit.dto.MemberDto;
import com.example.mealkit.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
    public String login(@ModelAttribute MemberDto memberDto, Model model){
        MemberDto loginResult = memberService.login(memberDto);

        if (loginResult != null){
            model.addAttribute("loginEmail", loginResult.getMemberEmail());
            return "home/main";
        } else {
            return "home/login";
        }
    }

    @GetMapping("/member/")
    public String findAll(Model model){
        List<MemberDto> memberDtoList = memberService.findAll();
//        어떠한 html로 가져갈 데이터가 있다면 model 사용
        model.addAttribute("memberList", memberDtoList);
        return "home/list";
    }

    @GetMapping("/member/{id}")
    public String findbyId(@PathVariable Long id, Model model){
        MemberDto memberDto = memberService.findbyId(id);
        model.addAttribute("member", memberDto);
        return "home/detail";
    }
}
