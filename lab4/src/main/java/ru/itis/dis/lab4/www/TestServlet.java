package ru.itis.dis.lab4.www;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


public class TestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

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
