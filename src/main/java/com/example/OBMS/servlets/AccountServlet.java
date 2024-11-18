package main.java.com.example.OBMS.servlets;

import com.example.banking.dao.AccountDAO;
import com.example.banking.utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addAccount")
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        double balance = Double.parseDouble(request.getParameter("balance"));

        try (Connection connection = DatabaseConnection.getConnection()) {
            AccountDAO dao = new AccountDAO(connection);
            dao.addAccount(name, email, balance);
            response.getWriter().write("Account added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
