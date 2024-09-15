package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.common.UserAlreadyExists;
import org.example.entity.User;
import org.example.service.UserService;
import org.example.service.VerifyOTP;

import java.io.IOException;

public class sendOTP extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User().setName(req.getParameter("name"))
                .setFamily(req.getParameter("family"))
                .setUsename(req.getParameter("cellphone"))
                .setPassword(req.getParameter("password"))
                .setCellphone(req.getParameter("cellphone"));
        try {
            UserService.checkDuplicateUsername(user);
        } catch (UserAlreadyExists e) {
            req.setAttribute("errorMessage", "That username is taken. Try another.");
            req.getRequestDispatcher("signup.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer otp = VerifyOTP.sendOTP(user);
        req.getSession().setAttribute("otp", otp);
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("verifyCode.jsp");
    }
}
