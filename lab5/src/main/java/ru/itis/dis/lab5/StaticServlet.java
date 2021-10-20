package ru.itis.dis.lab5;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(value = "/image/*", initParams = {@WebInitParam(name = "imagePath", value = "/opt/image")})
public class StaticServlet extends HttpServlet {

    private String imagePath;

    @Override
    public void init(ServletConfig config) {
        imagePath = config.getInitParameter("imagePath");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        // String path = imagePath + request.getPathInfo();
        String path = request.getServletContext().getRealPath(request.getServletPath()) +  request.getPathInfo();

        if (new File(path).exists()) {
            try {
                byte[] bufer = Files.readAllBytes(Paths.get(path));
                response.getOutputStream().write(bufer);
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
