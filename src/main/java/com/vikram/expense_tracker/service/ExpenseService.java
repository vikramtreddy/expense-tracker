package com.vikram.expense_tracker.service;

import com.vikram.expense_tracker.model.Expense;
import com.vikram.expense_tracker.model.User;
import com.vikram.expense_tracker.repository.ExpenseRepository;
import com.vikram.expense_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public String addExpense(String userId, String description, BigDecimal amount, String date) {
        // Find user by userId
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            return "User not found!";
        }

        // Convert String date to LocalDate
        LocalDate expenseDate = LocalDate.parse(date);

        // Create Expense and save
        Expense expense = new Expense(description, amount, expenseDate, userOptional.get());
        expenseRepository.save(expense);

        return "Expense added successfully!";
    }
}
