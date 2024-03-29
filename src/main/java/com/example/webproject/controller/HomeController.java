package com.example.webproject.controller;

import com.example.webproject.model.UserDtls;
import com.example.webproject.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/sigin")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDtls user, HttpSession session){

        boolean f=userService.checkEmail(user.getEmail());

        if(f){
            session.setAttribute("msg","email id exist");
        }
        else{
            UserDtls userDtls=userService.createUser(user);
            if(userDtls != null){
                session.setAttribute("msg","Good registering");
            }
            else {
                session.setAttribute("msg","oh my some error on server");
            }
        }




        //System.out.println(user);

        return "redirect:/register";
    }
}
