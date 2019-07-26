package com.expensetracker.expensetracker.service;

import com.expensetracker.expensetracker.exception.NotFoundException;
import com.expensetracker.expensetracker.model.Expense;
import com.expensetracker.expensetracker.model.User;
import com.expensetracker.expensetracker.repo.ExpenseRepository;
import com.expensetracker.expensetracker.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Expense> getAllUserExpenses(Long userId) {

        return expenseRepository.findByUserId(userId);

    }


    public Expense getExpense(Long Id) {

        Expense expense = expenseRepository.findById(Id).orElseThrow(() ->
                new NotFoundException("Expense with id " + Id + " not found"));

        return expense;

    }

    public Expense createNewExpense(Expense expense, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new NotFoundException("User with Id: " + userId + " does not exist"));

        expense.setUser(user);
        expenseRepository.save(expense);

        return expense;
    }
}
