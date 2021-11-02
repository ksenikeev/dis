import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCConnection {

    public static void main(String[] args){

        String url = "jdbc:postgresql://127.0.0.1:5432/cars";
        try (Connection conn = DriverManager.getConnection(url,"postgres","passwd")){

            Statement statement = conn.createStatement();

            statement.execute("ALTER TABLE driver ADD COLUMN driver_id bigint ");

            statement.execute("CREATE SEQUENCE driver_seq");

            statement.executeUpdate("UPDATE driver SET driver_id=nextval('driver_seq')");

            statement.execute("ALTER TABLE driver ADD CONSTRAINT pk_driver PRIMARY KEY (driver_id)");

            //statement.execute("ALTER TABLE driver ADD COLUMN driver_id serial PRIMARY KEY");


            // работа с БД;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
