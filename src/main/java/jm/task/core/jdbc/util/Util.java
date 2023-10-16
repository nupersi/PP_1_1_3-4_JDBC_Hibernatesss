package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.imageio.spi.ServiceRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static SessionFactory factory;

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

    public static SessionFactory getFactory () {
        if (factory == null) {
            try {
                Configuration config = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydatabase");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "Terminatoratm123.");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                config.setProperties(settings);
                config.addAnnotatedClass(User.class);
                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

                factory = config.buildSessionFactory(serviceRegistry);
            } catch (Exception exception) {
                System.out.println("Failed GETFACTORY method");
                exception.printStackTrace();
            }
        }
        return factory;
    }
}
