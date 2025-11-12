package com.launchpad.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Forward to login page
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        
        // TODO: Validate credentials against database
        // For now, simple demo validation
        if (isValidUser(email, password)) {
            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);
            session.setAttribute("loggedIn", true);
            
            // Redirect to dashboard or home
            response.sendRedirect("dashboard.jsp");
        } else {
            // Login failed - redirect back with error
            request.setAttribute("error", "Invalid email or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
    
    // Demo validation - replace with actual database check
    private boolean isValidUser(String email, String password) {
        // TODO: Check against database
        // For demo purposes only
        return email != null && password != null && 
               email.contains("@") && password.length() >= 6;
    }
}
