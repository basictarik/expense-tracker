package com.expensetracker.expensetracker.service;

import com.expensetracker.expensetracker.exception.NotFoundException;
import com.expensetracker.expensetracker.model.Expense;
import com.expensetracker.expensetracker.model.User;
import com.expensetracker.expensetracker.repo.ExpenseRepository;
import com.expensetracker.expensetracker.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteExpense(Long Id) {
        expenseRepository.deleteById(Id);
        log.info("Expense with id " + Id + " has been deleted");
    }

    public Expense updateExpense(Expense expense, Long userId, Long expenseId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new NotFoundException("User with Id: " + userId + " does not exist"));

        Expense updatedExpense = expenseRepository.findById(expenseId).orElseThrow(() ->
                new NotFoundException("Expense with Id " + expenseId + " not found"));

        updatedExpense.setAmount(expense.getAmount());
        updatedExpense.setCategory(expense.getCategory());
        updatedExpense.setDescription(expense.getDescription());
        expenseRepository.save(updatedExpense);

        log.info("Expense for user with Id: " + userId + " has been updated");

        return updatedExpense;
    }
}
