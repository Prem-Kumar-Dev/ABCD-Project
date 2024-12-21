package com.example.OBMS.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

public class LoginServlet extends HttpServlet {

    // Handle GET request to display the login form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("static/Login/index.html");
    }

    // Handle POST request to authenticate the user
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/User";
        String dbUser = "admin";
        String dbPassword = "Krprem514@";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            // SQL query to check if user exists with the provided username
            String sql = "SELECT * FROM User WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedHashedPassword = resultSet.getString("password");

                // Compare the provided password with the stored hashed password
                if (BCrypt.checkpw(password, storedHashedPassword)) {
                    // Authentication successful, redirect to dashboard or home page
                    response.sendRedirect("/dashboard");  // Change to the page you want after successful login
                } else {
                    // Incorrect password, redirect back to the login page with an error message
                    response.sendRedirect("/login?error=Invalid+password");
                }
            } else {
                // User not found, redirect back to the login page with an error message
                response.sendRedirect("/login?error=User+not+found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Redirect back to the login page with an error message
            response.sendRedirect("/login?error=An+error+occurred");
        }
    }
}
