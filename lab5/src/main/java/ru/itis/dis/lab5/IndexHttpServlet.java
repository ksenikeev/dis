package ru.itis.dis.lab5;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/index2.html")
public class IndexHttpServlet extends HttpServlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("IndexServlet init");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("IndexServlet doGet");

        String groupName = "11-013";

        request.getServletContext().setAttribute("group", groupName);

        try {
            request.getRequestDispatcher("/part2").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("IndexServlet destroy");
    }
}
