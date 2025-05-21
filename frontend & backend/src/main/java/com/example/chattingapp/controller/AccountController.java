package com.example.chattingapp.controller;

import com.example.chattingapp.model.Account;
import com.example.chattingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerAccount(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            accountService.registerAccount(username, password);
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index( Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        return "index";
    }

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public Account addUser(
            @Payload Account user
    ) {
        accountService.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public Account disconnectUser(
            @Payload Account user
    ) {
        accountService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Account>> findConnectedUsers() {
        return ResponseEntity.ok(accountService.findConnectedUsers());
    }
}
