package com.julian.soporte.cookie.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            Cookie usernameCookie = new Cookie("username", username);
            response.addCookie(usernameCookie);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Login correcto</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Login correcto!</h1>");
                out.println("        <h3>Hola "+ username + " has iniciado sesión con éxito!</h3>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/cookie-session/login.jsp").forward(request, response);
    }



}

