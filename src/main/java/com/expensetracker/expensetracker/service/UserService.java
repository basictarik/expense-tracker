package com.expensetracker.expensetracker.service;

import com.expensetracker.expensetracker.model.User;
import com.expensetracker.expensetracker.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> allUsers() {
        var rval = userRepository.findAll();
        var users = new ArrayList<User>();

        rval.forEach(e -> users.add(e));

        return users;
    }

    public void createUser(User user) {
        user.setEnabled(true);
        user.setTokenExpired(true);
        User savedUser = userRepository.save(user);
    }
}
