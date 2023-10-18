package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {


    private static Connection connection;

    private static SessionFactory factory;

    private final static String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Terminatoratm123.";

    public static Connection getConnection () {
//        if (!connection.isClosed()) {
//            System.out.println("Connection has been made");
//            return connection;
//        } else {
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

//    public static SessionFactory getFactory () {
//        if (factory == null) {
//            try {
//                Configuration config = new Configuration();
//
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydatabase");
//                settings.put(Environment.USER, "root");
//                settings.put(Environment.PASS, "Terminatoratm123.");
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//                settings.put(Environment.SHOW_SQL, "true");
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//
//                config.setProperties(settings);
//                config.addAnnotatedClass(User.class);
//                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
//
//                factory = config.buildSessionFactory(serviceRegistry);
//            } catch (Exception exception) {
//                System.out.println("Failed: GETFACTORY method has NOT been established");
//                exception.printStackTrace();
//            }
//        }
//        System.out.println("GETFACTORY method: Factory was obtained");
//        return factory;
//    }
}
