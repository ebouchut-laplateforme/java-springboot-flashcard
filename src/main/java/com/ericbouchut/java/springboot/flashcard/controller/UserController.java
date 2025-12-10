package com.ericbouchut.java.springboot.flashcard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/")
    public String listAllUsers() {
        return "users/index";
    }

    @PostMapping
    public String createUser(

    ) {
        // TODO: Do it
        return "/users/list";
    }
}
