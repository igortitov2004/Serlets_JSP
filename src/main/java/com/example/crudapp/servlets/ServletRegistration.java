package com.example.crudapp.servlets;

import com.example.crudapp.StaffDTO.StuffDTO;
import com.example.crudapp.StaffDTO.UserDTO;
import com.example.crudapp.StuffDAO.StuffDAO;
import com.example.crudapp.StuffDAO.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletRegistration", value = "/addUser")
public class ServletRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO newUser = new UserDTO();
        newUser.setId_user(null);
        newUser.setLogin(request.getParameter("login"));
        newUser.setPassword(request.getParameter("password"));
        newUser.setEmail(request.getParameter("email"));
        UserDAO userDAO = new UserDAO();
        userDAO.addUser(newUser);


        try{
            for (Cookie cookie:request.getCookies()) {
                Cookie cookie1 = new Cookie(cookie.getName(),"");
                cookie1.setMaxAge(0);
                response.addCookie(cookie1);
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",null);
        response.sendRedirect("/enterInSystem");
    }
}
