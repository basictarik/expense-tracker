package com.expensetracker.expensetracker.controller;

import com.expensetracker.expensetracker.model.Expense;
import com.expensetracker.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping(value = "{id}")
    public List<Expense> getUserExpenses(@RequestBody Long userId) {
        return expenseService.getAllUserExpenses(userId);
    }
}
