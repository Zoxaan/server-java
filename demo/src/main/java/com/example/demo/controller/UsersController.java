package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UsersController {
    private final UserService userService;


    @GetMapping("/all")
    public String getALLusers(Model model){
        model.addAttribute("users", userService.getALLusers());
        model.addAttribute("user", new User());
        return "index";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User users){
        userService.save(users);
        return "redirect:all";
    }
    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id){
        userService.delete(id);
        return "redirect:all";
    }
    @GetMapping("/edit")
    public String editUser(@RequestParam Long id, Model model){
        Optional<User> user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute User users){
        userService.save(users);
        return "redirect:all";
    }
}




