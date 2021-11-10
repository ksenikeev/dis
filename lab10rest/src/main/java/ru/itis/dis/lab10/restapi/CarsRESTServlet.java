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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cars")
public class CarsRESTServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        Connection conn = DbWork.getConnection();

       try {
           Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(
                    "SELECT car_id,  model FROM car");

           List<Car> lstCar = new ArrayList<>();

            while(rs.next()){
                //получение данных из очередной строки результата;
                lstCar.add(new Car(rs.getLong("car_id"),
                        rs.getString("model")));

            }
            rs.close();
            statement.close();

            response.setHeader("Content-Type","application/json");

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), lstCar);

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
}
