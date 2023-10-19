package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class Util {

    private Connection connection;//todo сломали... парадигму ООП, - избавляемся от static // Исправил

    private final String URL = "jdbc:mysql://localhost:3306/mydatabase";//todo сломали...  // Исправил
    private final String USERNAME = "root";
    private final String PASSWORD = "Terminatoratm123.";

    public Connection getConnection() {//todo сломали...  // Исправил
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection has been made");
                return connection;
            } else {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connection just is made");
                return connection;
            }
        } catch (SQLException e) {//todo почему SQLException? // Из документации https://docs.oracle.com/javase/8/docs/api/java/sql/DriverManager.html , там в ошибках этого метода - Timeout и просто SQL;
            e.printStackTrace();
        }
        return connection;
    }
}
