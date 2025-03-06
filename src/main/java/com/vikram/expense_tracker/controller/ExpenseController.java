package com.vikram.expense_tracker.controller;

import com.vikram.expense_tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<String> addExpense(@RequestParam String userId,
                                             @RequestParam String description,
                                             @RequestParam BigDecimal amount,
                                             @RequestParam String date) {
        String response = expenseService.addExpense(userId, description, amount, date);
        if (response.equals("User not found!")) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}
