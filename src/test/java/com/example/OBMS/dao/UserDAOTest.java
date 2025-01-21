package com.example.OBMS.dao;

import com.example.OBMS.model.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDAOTest {

    @Test
    public void testUserCreation() {
        // Create a BigDecimal for the account balance
        BigDecimal balance = new BigDecimal("1000.00");  // Example balance

        // Create User instance with valid data
        User user = new User(
                "1",              // ID (if your User class expects this as a String)
                "John Doe",       // Name
                "john@example.com",  // Email
                "password123",    // Password
                balance,          // Account balance
                "1234567890",      // Phone number
                new Timestamp(System.currentTimeMillis()),  // Created timestamp
                new Timestamp(System.currentTimeMillis()),  // Updated timestamp
                "Active"          // Status
        );

        // Assert that the user object is not null
        assertNotNull(user);

        // You can add further assertions here to test the user properties if needed
        System.out.println("User created successfully: " + user.getName());
    }
}
