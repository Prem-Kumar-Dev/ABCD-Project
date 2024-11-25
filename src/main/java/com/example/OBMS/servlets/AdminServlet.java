package main.java.com.example.OBMS.servlets;

import main.java.com.example.banking.dao.AdminDAO;
import main.java.com.example.banking.model.Admin;
import main.java.com.example.banking.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admins")
public class AdminServlet extends HttpServlet {

    private AdminDAO adminDAO;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DBUtils.getConnection();
            adminDAO = new AdminDAO(connection);
        } catch (SQLException e) {
            throw new ServletException("Database connection failed", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Admin> admins = adminDAO.getAllAdmins();
            req.setAttribute("admins", admins);
            req.getRequestDispatcher("/admins.jsp").forward(req, resp); // Forward to JSP for display
        } catch (SQLException e) {
            throw new ServletException("Error fetching admins", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phoneNumber = req.getParameter("phoneNumber");
        String role = req.getParameter("role");

        Admin admin = new Admin();
        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setPhoneNumber(phoneNumber);
        admin.setRole(role);
        admin.setStatus("ACTIVE");

        try {
            adminDAO.addAdmin(admin);
            resp.sendRedirect(req.getContextPath() + "/admins");
        } catch (SQLException e) {
            throw new ServletException("Error adding admin", e);
        }
   
