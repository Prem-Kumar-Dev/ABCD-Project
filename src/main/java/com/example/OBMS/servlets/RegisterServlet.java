package com.example.OBMS.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to the static registration HTML page
        response.sendRedirect("static/Register/index.html"); // Path to your register HTML page
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hash the password for security
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/User";
        String dbUser = "admin";
        String dbPassword = "Krprem514@";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            // SQL query to insert a new user
            String sql = "INSERT INTO User (name, email, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, username);
            statement.setString(4, hashedPassword);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                // Redirect to success page
                response.sendRedirect("/register-success.html");
            } else {
                // Redirect back to the registration form with an error message
                response.sendRedirect("/register?error=Registration+failed.+Try+again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Redirect back to the registration form with an error message
            response.sendRedirect("/register?error=An+error+occurred.+Please+try+again.");
        }
    }
}
