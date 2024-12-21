package com.example.OBMS;

import java.sql.Connection;  // Correct import for DBConnection
import java.sql.SQLException;

import com.example.OBMS.utils.DBConnection;

public class OBMS {  
    public static void main(String[] args) {
        // Initialize the application and check database connection
        try {
            System.out.println("Starting OBMS Application...");
            initializeDatabase();
            // Additional setup or service initialization can be done here
            System.out.println("OBMS Application started successfully.");
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }

    // Initialize the database connection
    private static void initializeDatabase() throws SQLException {
        // This method checks if the connection to the database is successful
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Database connected successfully!");
            } else {
                System.err.println("Failed to connect to the database.");
            }
        }
    }
}
