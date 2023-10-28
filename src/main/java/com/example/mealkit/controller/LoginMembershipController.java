package com.example.mealkit.controller;

import com.example.mealkit.dto.UsersForm;
import com.example.mealkit.entity.Users;
import com.example.mealkit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class LoginMembershipController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/new")
    public String NewMembership(){
        return "/membership/membership";
    }

    /**
     * CreateUsers (생성 Controller)
     * PostMapping
     * User 정보를 생성
     */
    @PostMapping("/login/membership/create")
    public String CreateUsers(UsersForm dto){
        log.info(dto.toString());
//        dto 로 들어온 데이터확인
        userService.create(dto);
//      회원가입이 완료됐을때 로그인 화면으로 이동
        return "redirect:/login";
    }

//    @GetMapping("/login/membership/{id}/edit")
//    public String update(@PathVariable Long id, Model model){
//        UsersForm dto = userService.findby(id);
//        model.addAttribute(, dto);
//        return "/membership/membership/{id}/Update";
//    }

    @GetMapping("/login/membership/{id}/edit")
    public String Update(@PathVariable Long id, Model model){
        model.addAttribute("userUpdate", userService.show(id));
//        mustache show 파일 하나만 만들어서 수정해서 보내는거 만들기
        return "/membership/membershipUpdate";
    }

    /**
     * UpdateUsers (업데이트 controller)
     * PostMapping
     * UsersForm 에서 정보를 받음
     * */
    @PostMapping("/login/membership/update")
    public String UpdateUsers(UsersForm dto){
        log.info(dto.toString());
        Users users = dto.toEntity();
//        Users target = users.
//        userService.update(id, dto);
//        model.addAttribute("usersUpdate", userService.show(id));
        return ("redirect:/login/membership/" + "");
    }


    /**
     * DeleteUsers (삭제 controller)
     * GetMapping
     */

    @GetMapping("/login/membershipList/{id}/delete")
    public String DeleteUsers(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/login/membershipList";
    }

    /**
     * MembershipList (전체출력 controller)
     * GetMapping
     * */
    @GetMapping("/login/membershipList")
    public String MembershipList(Model model){
        List<Users> usersList = userService.findList();
        model.addAttribute("usersList", userService.findList());
        return "/membership/membershipList";
    }



}
