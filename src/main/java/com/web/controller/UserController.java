package com.web.controller;

import com.web.models.User;
import com.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/new")
    public String createUserForm(User user){
        return "new";
    }

    @PostMapping("/new")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/update";
    }

    @PostMapping("/update")
    public String updateUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
}