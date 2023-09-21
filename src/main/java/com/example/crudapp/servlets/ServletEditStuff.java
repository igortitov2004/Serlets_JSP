package com.example.crudapp.servlets;

import com.example.crudapp.StaffDTO.StuffDTO;
import com.example.crudapp.StuffDAO.StuffDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletEditStuff", value = "/editStuff")
public class ServletEditStuff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StuffDTO newStuff = new StuffDTO();
        newStuff.setId_staff(Integer.parseInt(request.getParameter("id")));
        newStuff.setFirstName(request.getParameter("firstName"));
        newStuff.setLastName(request.getParameter("lastName"));
        newStuff.setPhoneNumber(request.getParameter("phoneNumber"));
        newStuff.setRole((request.getParameter("role")));
        StuffDAO stuffDAO = new StuffDAO();
        stuffDAO.editStuff(newStuff);
        response.sendRedirect("/stuff");
    }
}
