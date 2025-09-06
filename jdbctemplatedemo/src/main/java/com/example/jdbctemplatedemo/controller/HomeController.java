package com.example.jdbctemplatedemo.controller;

import com.example.jdbctemplatedemo.model.User;
import com.example.jdbctemplatedemo.service.RegisterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@AllArgsConstructor
@Controller
public class HomeController {

    private final RegisterService registerService;

    @GetMapping({"/home", "", "/"})
    public String showHomePage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    //valid -  i used to tell wheather user is valid or not
    public String register(@Valid @ModelAttribute User user , BindingResult result){
        System.out.println("Printing the user details:"+user);
        if (result.hasErrors())
        {
            return "register";
        }
        registerService.register(user);
        return "success";
    }
}
