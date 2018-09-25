package com.ssmelnikov.demo.controllers;

import com.ssmelnikov.demo.items.UserSecDetails;
import com.ssmelnikov.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/helloGuest")
    public String getHello(Map<String, Object> model, @AuthenticationPrincipal UserSecDetails userDetails) {
        model.put("user", userDetails.getUser().getFirstName() + " " + userDetails.getUser().getLastName());
        return "hello_guest";
    }
}
