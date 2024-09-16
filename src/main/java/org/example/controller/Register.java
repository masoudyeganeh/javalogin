package org.example.controller;

//@WebServlet("/one.jsp")

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entity.User;
import org.example.service.UserService;

import java.io.IOException;

public class Register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");
        User user = new User().setUsename(username).setPassword(password);
        try {
            if(UserService.auth(user)) {
                resp.getWriter().println("welcome dear " + user.getUsename());
                req.getSession().setAttribute("username", username);
                if ("on".equals("rememberMe")) {
                    Cookie rememberMeCookie = new Cookie("rememberMe", username);
                    rememberMeCookie.setMaxAge(7 * 24 * 60 * 60);
                    rememberMeCookie.setHttpOnly(true);
                    rememberMeCookie.setSecure(true);
                    resp.addCookie(rememberMeCookie);
                }
                resp.sendRedirect("welcome.jsp");
            } else {
                req.setAttribute("errorMessage", "invalid username or password");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
//                resp.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
