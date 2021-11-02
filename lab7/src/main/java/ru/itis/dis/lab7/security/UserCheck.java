package ru.itis.dis.lab7.security;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/usercheck")
public class UserCheck extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (true) // check login & password
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("user","kamil");
        }

        try {
            //request.getRequestDispatcher("redirect.ftlh").forward(request,response);
            response.sendRedirect("/lab7/index");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
