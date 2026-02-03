package com.example.Lab02.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/home")
    public String Index(){
        return "index";
    }
}
