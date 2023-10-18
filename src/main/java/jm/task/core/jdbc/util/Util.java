package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static Connection connection;//todo сломали... парадигму ООП, - избавляемся от static

    private final static String URL = "jdbc:mysql://localhost:3306/mydatabase";//todo сломали...
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Terminatoratm123.";

    public static Connection getConnection() {//todo сломали...
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection has been made");
                return connection;
            } else {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connection just is made");
                return connection;
            }
        } catch (SQLException e) {//todo почему SQLException?
            e.printStackTrace();
        }
        System.out.println("Failed: Сonnection has NOT been established");//todo код в каком случае сюда дойдет?
        return connection;
    }
}
