package ru.itis.dis.lab6;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/usercheck")
public class UserCheck extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username + "&" + password);

        request.getSession(true);

        request.setAttribute("groupp","11-013");
        request.setAttribute("date", new SimpleDateFormat("dd.MM.yyyy").format(new Date()));


        try {
            request.getRequestDispatcher("index.ftlh").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
