package com.expensetracker.expensetracker.controller;

import com.expensetracker.expensetracker.model.User;
import com.expensetracker.expensetracker.repo.UserRepository;
import com.expensetracker.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public List<User> users;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.allUsers();
    }
}
