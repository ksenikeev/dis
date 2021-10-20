package ru.itis.dis.lab5;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/part2")
public class IndexHttpServletPart2 extends HttpServlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("IndexServletPart2 init");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("IndexServletPart2");

        String groupName = (String) request.getServletContext().getAttribute("group");

        try {
            response.getWriter().write("from servlet 2 " + groupName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("IndexServlet destroy");
    }
}
