package ru.itis.dis.lab10.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.dis.lab10.DbWork;
import ru.itis.dis.lab10.dto.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/car/*")
public class CarByIdRESTServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("request.getContextPath():" + request.getContextPath());
        System.out.println("request.getPathInfo():" + request.getPathInfo());
        System.out.println("request.getServletPath():" + request.getServletPath());

        Long id = 0l;

        String car_id = request.getParameter("car_id");

        if (car_id == null) {
            car_id = request.getPathInfo() != null ? request.getPathInfo().substring(1) : null;
        }

        if (car_id != null) {
            try {
                id = Long.parseLong(car_id);
            } catch (NumberFormatException e) {
                response.sendError(500, "Неверный id");            }
        } else {
            response.sendError(500, "Неверный id");
        }


        Connection conn = DbWork.getConnection();

       try {
           PreparedStatement statement = conn.prepareStatement("SELECT car_id,  model FROM car where car_id = ? ");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

           Car car = null;

            if(rs.next()){
                //получение данных из очередной строки результата;
                car  = new Car(rs.getLong("car_id"),
                        rs.getString("model"));
            }
            rs.close();
            statement.close();

            response.setHeader("Content-Type","application/json");

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), car);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


        try {
            request.getRequestDispatcher("index.ftlh").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Car car = mapper.readValue(request.getInputStream(), Car.class);
            if (car != null && car.getCar_id() != null) {
                //TODO get from db

                Car respCar = new Car(car.getCar_id(), "model");

                mapper.writeValue(response.getOutputStream(), respCar);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
