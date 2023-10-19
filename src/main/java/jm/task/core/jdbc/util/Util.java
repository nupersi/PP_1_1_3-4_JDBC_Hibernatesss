package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class Util {

    private Connection connection;

    private final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private final String USERNAME = "root";
    private final String PASSWORD = "Terminatoratm123.";

    public Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection has been made");
                return connection;
            } else {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connection just is made");
                return connection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
