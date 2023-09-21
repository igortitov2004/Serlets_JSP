package com.example.crudapp.servlets;

import com.example.crudapp.StaffDTO.UserDTO;
import com.example.crudapp.StuffDAO.StuffDAO;
import com.example.crudapp.StuffDAO.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAuthorization", value = "/authorization")
public class ServletAuthorization extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(request.getParameter("login"));
        userDTO.setPassword(request.getParameter("password"));
        UserDAO userDAO = new UserDAO();
        if(userDAO.checkAuth(userDTO)){
            response.sendRedirect("/stuff");
        }else{
            response.sendRedirect("/enterInSystem");

        }
    }
}
