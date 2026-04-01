package academy.devdojo.maratonajava.javacore.ZZIjdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory {
    // java.sql = Connection, Statement, ResultSet, DriverManager
    public static void getConnection() {
        String url = "JDBC:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);
            System.out.println(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
