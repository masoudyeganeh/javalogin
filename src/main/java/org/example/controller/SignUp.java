package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entity.User;
import org.example.service.UserService;
import org.example.common.UserAlreadyExists;

import java.io.IOException;

public class SignUp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String family = req.getParameter("family");
        String cellphone = req.getParameter("cellphone");
        String password = req.getParameter("password");
        User user = new User()
                .setUsename(cellphone)
                .setPassword(password)
                .setName(name)
                .setFamily(family)
                .setCellphone(cellphone);
        try {
            UserService.checkDuplicateUsername(user);
            req.getRequestDispatcher("sendOTP.jsp").forward(req, resp);
        } catch (UserAlreadyExists e) {
            req.setAttribute("errorMessage", "That username is taken. Try another.");
            req.getRequestDispatcher("signup.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
