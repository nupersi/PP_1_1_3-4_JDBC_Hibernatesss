package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private final static String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Terminatoratm123.";

    public static Connection getConnection () {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("OK");
                return connection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Failed");
        return null;
    }
}
