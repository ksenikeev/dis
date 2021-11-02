package ru.itis.dis.lab7.security;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class Logout extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        request.getSession().invalidate();

        try {
            request.getRequestDispatcher("login.ftlh").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
