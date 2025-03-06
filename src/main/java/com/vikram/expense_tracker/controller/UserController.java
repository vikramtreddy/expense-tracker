package com.vikram.expense_tracker.controller;

import com.vikram.expense_tracker.model.User;
import com.vikram.expense_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get/users")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

}
