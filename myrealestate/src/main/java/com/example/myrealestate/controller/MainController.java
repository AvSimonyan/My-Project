package com.example.myrealestate.controller;

import com.example.myrealestate.model.CurrentUser;
import com.example.myrealestate.model.User;
import com.example.myrealestate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

@GetMapping("/")
    public  String main(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser){
    if (currentUser!=null){
    modelMap.addAttribute("currentUser",currentUser.getUser());
    }
    return "index";
    }

    @GetMapping("/login")
    public  String login(ModelMap modelMap){

        return "login";
    }
    @GetMapping("/register")
    public  String registerGet(){
        return "register";
    }

    @PostMapping("/register")
    public  String registerPost(@ModelAttribute User user){
     user.setPassword(passwordEncoder.encode(user.getPassword()));
     userRepository.save(user);
     return "redirect:/login";
    }
}
