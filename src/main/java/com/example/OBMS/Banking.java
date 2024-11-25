package main.java.com.example.OBMS;

import main.java.com.example.banking.utils.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Banking {
    public static void main(String[] args) {
        // Initialize the application and check database connection
        try {
            System.out.println("Starting Banking Application...");
            initializeDatabase();
            // Additional setup or service initialization can be done here
            System.out.println("Banking Application started successfully.");
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
