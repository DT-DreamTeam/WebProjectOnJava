package com.example.webproject.controller;

import com.example.webproject.model.UserDtls;
import com.example.webproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserRepository userRepo;


    @ModelAttribute
    private void userDetails(Model m, Principal p){

        String email = p.getName();
        UserDtls user=userRepo.findByEmail(email);
        m.addAttribute("user",user);
    }

    @GetMapping("/")
    public String home(){
        return "user/home";
    }

}
