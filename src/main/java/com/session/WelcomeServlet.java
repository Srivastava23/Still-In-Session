package com.session;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * WelcomeServlet - Reads session data and displays a welcome message.
 * 
 * This servlet checks if a valid session exists:
 * - If yes: displays the welcome message with the username
 * - If no: shows a "Session expired" message
 */
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // getSession(false) returns the existing session, but does NOT create a new one
        // Returns null if no session exists
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Session exists - read the username stored during login
            String username = (String) session.getAttribute("user");

            out.println("<html><body>");
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<p>Your session ID: " + session.getId() + "</p>");
            out.println("<a href='logout'>Logout</a>");
            out.println("</body></html>");
        } else {
            // No session found - user hasn't logged in or session expired
            out.println("<html><body>");
            out.println("<h2>Session expired. Please login again.</h2>");
            out.println("<a href='login.html'>Login</a>");
            out.println("</body></html>");
        }

        out.close();
    }
}
