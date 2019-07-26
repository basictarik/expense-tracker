package com.expensetracker.expensetracker.controller;

import com.expensetracker.expensetracker.exception.NotFoundException;
import com.expensetracker.expensetracker.model.Expense;
import com.expensetracker.expensetracker.model.User;
import com.expensetracker.expensetracker.repo.UserRepository;
import com.expensetracker.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping(value = "{userId}/expenses")
    public List<Expense> getUserExpenses(@PathVariable long userId) {
        return expenseService.getAllUserExpenses(userId);
    }

    @PostMapping(value = "{userId}/expenses")
    public Expense createExpense(@RequestBody Expense expense, @PathVariable long userId) {
        Expense createdExpense = expenseService.createNewExpense(expense, userId);
        return createdExpense;
    }

    @GetMapping(value = "{userId}/expenses/{expenseId}")
    public Expense getExpense(@PathVariable Long expenseId) {
        return expenseService.getExpense(expenseId);
    }


}
