package com.ssmelnikov.demo.controllers;

import com.ssmelnikov.demo.items.UserSecDetails;
import com.ssmelnikov.demo.repo.ChatRepository;
import com.ssmelnikov.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Melnikov_S on 22.09.2017.
 */
@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ChatRepository chatRepo;

    @RequestMapping("/home")
    public String getHome(Map<String, Object> model, @AuthenticationPrincipal UserSecDetails userDetails) {
        model.put("user", userDetails.getUser());
        try {
            model.put("chats", chatRepo.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }
}
