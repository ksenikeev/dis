package ru.itis.dis.lab4.www;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = request.getCookies()[0];

        cookie.getName();

        //request.getCookies()


        try {
            OutputStream os = response.getOutputStream();

            String s = "<html><body>Hello!</body></html>";

            os.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("get");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("post");
    }
}
