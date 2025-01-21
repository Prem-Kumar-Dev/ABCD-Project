package com.example.OBMS.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private BigDecimal accountBalance;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String status;

    // Updated constructor with meaningful parameter names
    public User(String userId, String name, String email, String password, BigDecimal accountBalance, String phoneNumber, Timestamp createdAt, Timestamp updatedAt, String status) {
        this.userId = Integer.parseInt(userId);  // Assuming userId is passed as a String
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountBalance = accountBalance;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public User() {

    }

    // Getters and Setters for all fields

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
