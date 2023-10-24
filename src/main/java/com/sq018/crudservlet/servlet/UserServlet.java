package com.sq018.crudservlet.servlet;

import com.sq018.crudservlet.dao.UserDAO;
import com.sq018.crudservlet.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    private UserDAO userDAO;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("dashboard.jsp");

        List<User> users =  userDAO.getAllUsers();

        request.setAttribute("users", users);
        requestDispatcher.forward(request, response);
    }
}
