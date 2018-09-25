package com.ssmelnikov.demo.controllers;

import com.ssmelnikov.demo.entity.User;
import com.ssmelnikov.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Melnikov_S on 21.09.2017.
 */
@Controller
public class SignupController {
    @Autowired
    private UserRepository repository;


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String postSignup(@ModelAttribute("user") User user, Map<String, Object> model) {
        repository.save(user);
        model.put("user", user);
        return "user_created";
    }
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignup(Map<String, Object> model) {
        model.put("user", new User());
        return "signup";
    }
}
