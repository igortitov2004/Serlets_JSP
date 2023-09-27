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
        HttpSession session = request.getSession();
        session.setAttribute("user",null);
            UserDTO userDTO = new UserDTO();
            userDTO.setLogin(request.getParameter("login"));
            userDTO.setPassword(request.getParameter("password"));
            UserDAO userDAO = new UserDAO();
            userDTO.setRole(userDAO.getRole(request.getParameter("login")));
            if(userDAO.checkAuth(userDTO)){
                session.setAttribute("user",userDTO);

                Cookie cookieLoginDel = new Cookie("login","");
                cookieLoginDel.setMaxAge(0);
                Cookie cookiePassDel = new Cookie("pass","");
                cookiePassDel.setMaxAge(0);
                response.addCookie(cookieLoginDel);
                response.addCookie(cookiePassDel);

                Cookie cookieLogin = new Cookie("login",userDTO.getLogin());
                Cookie cookiePass = new Cookie("pass",userDTO.getPassword());
//                cookiePass.setMaxAge(-1);
//                cookieLogin.setMaxAge(-1);
                response.addCookie(cookieLogin);
                response.addCookie(cookiePass);
                response.sendRedirect("/stuff");
            }else{
                response.sendRedirect("/enterInSystem");
            }


    }
}
