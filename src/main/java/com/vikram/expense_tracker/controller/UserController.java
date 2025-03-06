package com.vikram.expense_tracker.controller;

import com.vikram.expense_tracker.model.User;
import com.vikram.expense_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @PostMapping("/create")
    public void createUser(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam int age){
        userService.createUser(name, email, age);
    }

}
