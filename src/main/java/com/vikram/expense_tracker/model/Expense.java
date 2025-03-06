package com.vikram.expense_tracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection = "expenses")  // Maps this class to the "expenses" collection in MongoDB
public class Expense {
    @Id
    private String id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;

    @DBRef  // Reference to User collection
    private User user;

    // Constructors
    public Expense() {}

    public Expense(String description, BigDecimal amount, LocalDate date, User user) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.user = user;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
