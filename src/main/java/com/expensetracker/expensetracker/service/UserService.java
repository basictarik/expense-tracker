package com.expensetracker.expensetracker.service;

import com.expensetracker.expensetracker.dto.UserSummary;
import com.expensetracker.expensetracker.security.UserPrincipal;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserSummary getCurrentUser(UserPrincipal userPrincipal) {
        return UserSummary.builder()
                .id(userPrincipal.getId())
                .email(userPrincipal.getEmail())
                .name(userPrincipal.getName())
                .build();
    }
}
