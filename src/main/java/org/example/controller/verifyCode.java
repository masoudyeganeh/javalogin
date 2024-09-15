package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entity.User;
import org.example.service.UserService;

import java.io.IOException;

public class verifyCode extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") != null) {
            resp.sendRedirect("welcome.jsp");
        }
        Integer mainOTP = Integer.valueOf(req.getSession().getAttribute("otp").toString());
        Integer otp = Integer.valueOf(req.getParameter("otp"));
        User user = (User) req.getSession().getAttribute("user");
        if (mainOTP.equals(otp)) {
            try {
                UserService.signUp(user);
                resp.sendRedirect("welcome.jsp");
                req.getSession().setAttribute("username", user.getUsename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("errorMessage", "wrong otp!");
            req.getRequestDispatcher("verifyCode.jsp").forward(req, resp);
        }
    }
}
