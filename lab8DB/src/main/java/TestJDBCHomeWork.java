import java.sql.*;

public class TestJDBCHomeWork {

    public static void main(String[] args){

        String url = "jdbc:postgresql://127.0.0.1:5432/homework";
        try (Connection conn = DriverManager.getConnection(url,"postgres","passwd")){

            Statement statement = conn.createStatement();

            statement.execute("create table a (id bigint primary key, name varchar(100)) ");

            statement.executeUpdate("insert into a (id, name) values (1,'1'), (2,'2'), (3,'3')");

            statement.close();

            String sql = "SELECT id , name FROM a where true ";

            PreparedStatement statement1 = conn.prepareStatement(sql);

            //statement1.setInt(1, 2);
            //statement1.setString(2, "driver%");

            ResultSet rs = statement1.executeQuery();

            System.out.println("------------------------------------------------------------------");
            System.out.println("id | name |");
            System.out.println("------------------------------------------------------------------");
            while(rs.next()){
                //получение данных из очередной строки результата;
                System.out.println(rs.getString("id") + "|"
                        + rs.getString("name") + "|");

            }
            rs.close();
            statement1.close();



            // работа с БД;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
