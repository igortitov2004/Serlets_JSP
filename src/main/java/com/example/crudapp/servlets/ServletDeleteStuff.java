package com.example.crudapp.servlets;

import com.example.crudapp.StaffDTO.StuffDTO;
import com.example.crudapp.StuffDAO.StuffDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletDeleteStuff", value = "/deleteStuff")
public class ServletDeleteStuff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer integer  = Integer.valueOf(request.getParameter("id"));
        StuffDAO stuffDAO = new StuffDAO();
        stuffDAO.deleteStuff(integer);
        response.sendRedirect("/stuff");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/stuff.jsp");
//        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
