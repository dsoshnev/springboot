package ru.dsoshnev.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String index(Model model) {
        model.addAttribute("message", "My First Spring Boot App");
        return "index";
    }
}
