import java.sql.*;

public class TestJDBCSelectParams {

    public static void main(String[] args){

        String url = "jdbc:postgresql://127.0.0.1:5432/cars";
        try (Connection conn = DriverManager.getConnection(url,"postgres","passwd")){

            String sql = "SELECT driver_id as id, name, car_id FROM driver where car_id = ? and name like ? ";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, 2);
            statement.setString(2, "driver%");

            ResultSet rs = statement.executeQuery();

            System.out.println("------------------------------------------------------------------");
            System.out.println("driver_id | name | car_id");
            System.out.println("------------------------------------------------------------------");
            while(rs.next()){
                //получение данных из очередной строки результата;
                System.out.println(rs.getString("id") + "|"
                        + rs.getString("name") + "|"
                            + rs.getString("car_id") + "|");

            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
