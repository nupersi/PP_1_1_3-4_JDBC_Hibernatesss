package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {


    private static Connection connection;

    private final static String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Terminatoratm123.";

    public static Connection getConnection () {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection has been made");
                return connection;
            } else {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connection has been made");
                return connection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Failed: Сonnection has NOT been established");
        return connection;
    }
}
