package com.expensetracker.expensetracker.controller;

import com.expensetracker.expensetracker.model.User;
import com.expensetracker.expensetracker.repo.UserRepository;
import com.expensetracker.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public List<User> users;

    @RequestMapping(value = "/signup", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded")
    public void signup(@RequestBody User user) {
        userService.createUser(user);
    }
}
