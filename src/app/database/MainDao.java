package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainDao {
    Connection connection;
    Statement statement;
    final String url = "jdbc:postgresql://localhost:5432/logistics";
    final String user = "postgres";
    final String password = "admin";

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
//            System.out.println("Successfully connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
