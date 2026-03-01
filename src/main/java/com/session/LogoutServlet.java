package com.session;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * LogoutServlet - Invalidates the session and logs the user out.
 * 
 * This servlet:
 * 1. Gets the existing session
 * 2. Invalidates (destroys) it
 * 3. Shows a logout confirmation message
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the existing session (don't create a new one)
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Invalidate the session - this destroys all session data
            session.invalidate();
        }

        // Display logout confirmation
        out.println("<html><body>");
        out.println("<h2>You have been logged out successfully.</h2>");
        out.println("<a href='login.html'>Login Again</a>");
        out.println("</body></html>");

        out.close();
    }
}
