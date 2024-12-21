package com.example.OBMS.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdatabase"; // Your database name
    private static final String DB_USERNAME = "root";  // Your MySQL username
    private static final String DB_PASSWORD = "Krprem514@";  // Your MySQL password

    // Method to get a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
}
