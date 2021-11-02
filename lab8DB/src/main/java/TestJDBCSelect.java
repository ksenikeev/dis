import java.sql.*;

public class TestJDBCSelect {

    public static void main(String[] args){

        String url = "jdbc:postgresql://127.0.0.1:5432/cars";
        try (Connection conn = DriverManager.getConnection(url,"postgres","passwd")){

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT driver_id as id, name, car_id FROM driver");

            System.out.println("------------------------------------------------------------------");
            System.out.println("driver_id | name | car_id");
            System.out.println("------------------------------------------------------------------");
            while(rs.next()){
                //получение данных из очередной строки результата;
                System.out.println(rs.getString("id") + "|"
                            + rs.getString("name") + "|"
                            + rs.getString("car_id") + "|");

                System.out.println(rs.getString(3) + "|"
                        + rs.getString(1) + "|"
                        + rs.getString(2) + "|");
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
