package com.ssmelnikov.demo.controllers;

import com.ssmelnikov.demo.entity.Chat;
import com.ssmelnikov.demo.entity.Message;
import com.ssmelnikov.demo.items.UserSecDetails;
import com.ssmelnikov.demo.repo.ChatRepository;
import com.ssmelnikov.demo.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Melnikov_S on 22.09.2017.
 */
@Controller
public class ChatController {
    @Autowired
    private ChatRepository chatRepo;
    @Autowired
    private MessageRepository messageRepo;

    @RequestMapping(value = "/create_new_chat", method = RequestMethod.POST)
    public String postCreateNewChat(@ModelAttribute("chat") Chat chat, @AuthenticationPrincipal UserSecDetails userDetails) {
        chat.setCreatedBy(userDetails.getUser().getId());
        chatRepo.save(chat);
        return "redirect:/home";
    }

    @RequestMapping(value = "/create_new_chat", method = RequestMethod.GET)
    public String getCreateNewChat(Map<String, Object> model) {
        Chat chat = new Chat();
        model.put("chat", new Chat());
        return "create_new_chat";
    }

    @RequestMapping(value = "/view_chat", method = RequestMethod.GET)
    public String getViewChat(Map<String, Object> model, @RequestParam("chat_id") String id) {
        Chat chat = chatRepo.findOne(id);
        List<Message> messages = messageRepo.findByChatld(id);
        model.put("newMessage", new Message());
        model.put("chat", chat);
        model.put("messages", messages);
        return "view_chat";
    }

    @RequestMapping(value = "/post_message", method = RequestMethod.POST)
    public String postMessage(@ModelAttribute("newMessage") Message message, @RequestParam("chat_id") String chatId, @AuthenticationPrincipal UserSecDetails userDetails) {
        message.setDt(new Date());
        message.setUser(userDetails.getUser().getLogin());

        message.setChatld(chatId);
        messageRepo.save(message);
        return "redirect:/view_chat?chat_id="+chatId;
    }
}
