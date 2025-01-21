package com.example.OBMS.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.OBMS.dao.UserDAO;
import com.example.OBMS.model.User;

@WebServlet("/user") // Maps this servlet to the "/user" URL
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        // Initialize UserDAO
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email"); // Get email from request parameter

        if (email != null && !email.trim().isEmpty()) {
            try {
                // Fetch user by email
                User user = userDAO.getUserByEmail(email);
                if (user != null) {
                    req.setAttribute("user", user); // Set user as a request attribute
                    req.getRequestDispatcher("/userDetails.jsp").forward(req, resp); // Forward to JSP page
                } else {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found"); // User not found
                }
            } catch (SQLException e) {
                throw new ServletException("Error retrieving user", e); // Handle SQL exception
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Email parameter is missing"); // Bad request
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Handle POST requests (if needed)
    }
}
