package com.example.mealkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MealkitController {
    @GetMapping("/main")
    public String Main(){
        return "/main/mealkit";
    }

    @GetMapping("/mealkit/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model){

        return "";
    }
}
