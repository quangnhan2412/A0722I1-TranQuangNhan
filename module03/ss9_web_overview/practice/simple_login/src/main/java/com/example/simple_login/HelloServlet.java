package com.example.simple_login;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");

        if ("admin".equals(username) && "admin".equals(password)) {
            writer.println("<h1>Welcome " + username + " to website</h1>");
        } else {
            writer.println("<h1>Login Error</h1>");
        }

        writer.println("</html>");
    }
}