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
import java.sql.SQLException;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("edituser.jsp");

        User user = null;
        try {
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);

            user = UserDAO.getUserByID(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("id", user.getId());
        request.setAttribute("name", user.getName());
        request.setAttribute("password", user.getPassword());
        request.setAttribute("email", user.getEmail());
        request.setAttribute("country", user.getCountry());

        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setCountry(request.getParameter("country"));

        boolean isSuccessful = UserDAO.updateUser(user) == 1;

        response.setContentType("application/json");
        response.setStatus(isSuccessful ? HttpServletResponse.SC_OK : HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.getWriter().write("{\"success\": " + isSuccessful + "}");

        response.sendRedirect("UserServlet");
    }
}
