package ru.itis.dis.lab5;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/index.html")
public class IndexServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("IndexServlet init");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("IndexServlet get config");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(servletRequest.getProtocol());
        if (servletRequest.getProtocol().startsWith("HTTP"))
        System.out.println("IndexServlet service " + ((HttpServletRequest)servletRequest).getMethod());

        servletRequest.setAttribute("groupp","11-013");
        servletRequest.setAttribute("date", new SimpleDateFormat("dd.MM.yyyy").format(new Date()));


        try {
            servletRequest.getRequestDispatcher("index.ftlh").forward(servletRequest,servletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        System.out.println("IndexServlet servlet info");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("IndexServlet destroy");
    }
}
