package com.example.OBMS.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Log the request to verify flow
        System.out.println("In HomeServlet doGet method");

        // Redirect to the static index.jsp page
        response.sendRedirect("static/Cover/index.jsp");
    }
}
