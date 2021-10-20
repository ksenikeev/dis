package ru.itis.dis.lab5;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/resources/*")
public class StaticServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String path = "/resource" + request.getPathInfo();

        System.out.println(path);

        InputStream is = StaticServlet.class.getResourceAsStream(path);
        byte[] bufer = new byte[2048];
        int r = 0;
        if (is != null) {
            try {
                while ((r = is.read(bufer)) != -1) {
                    response.getOutputStream().write(bufer, 0, r);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.sendError(404, "Not found!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
