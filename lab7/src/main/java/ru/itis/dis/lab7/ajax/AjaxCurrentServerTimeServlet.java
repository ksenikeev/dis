package ru.itis.dis.lab7.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/server_time")
public class AjaxCurrentServerTimeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String serverTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S")
                .format(new Date());

        try {
            response.getOutputStream().write(serverTime.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
