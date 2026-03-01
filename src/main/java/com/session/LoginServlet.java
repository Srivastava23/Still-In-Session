package com.session;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * LoginServlet - Handles user login and creates a new HTTP session.
 * 
 * When the user submits the login form, this servlet:
 * 1. Reads the username from the form
 * 2. Creates a new HTTP session
 * 3. Stores the username in the session
 * 4. Redirects to the WelcomeServlet
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Read the username from the login form
        String username = request.getParameter("username");

        // Step 2: Create a new session (or get existing one)
        // getSession() creates a new session if one doesn't exist
        HttpSession session = request.getSession();

        // Step 3: Store the username in the session as an attribute
        session.setAttribute("user", username);

        // Step 4: Redirect the user to the welcome page
        response.sendRedirect("welcome");
    }
}
