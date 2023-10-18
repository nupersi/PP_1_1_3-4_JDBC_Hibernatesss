package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {

    Connection connection = getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String create = "CREATE TABLE IF NOT EXISTS `mydatabase`.`userstable` (\n" +
                "  `id` BIGINT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) ,\n" +
                "  `lastName` VARCHAR(45) ,\n" +
                "  `age` TINYINT ,\n" +
                "  PRIMARY KEY (`id`));\n";
        try (Statement statement = connection.createStatement()) {
            statement.execute(create);
            System.out.println("DBTable users has been created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String drop = "DROP TABLE IF EXISTS userstable";
        try (Statement statement = connection.createStatement()) {
            statement.execute(drop);
            System.out.println("DBTable \"users\" has been dropped");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String save = "INSERT INTO userstable (name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(save)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User name:" + name + "; lastName:" + lastName + "; age:" + age + " has been saved");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        if (id > 0) {
            String remove = "DELETE FROM userstable WHERE id = id";
            try (PreparedStatement preparedStatement = connection.prepareStatement(remove)) {
                preparedStatement.executeUpdate();
                System.out.println("User id:" + id + " has been remove");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed removeUser: User id <= 0");
        }
    }

    public List<User> getAllUsers() {
        List <User> rslist = new ArrayList<>();

        String getAll = "SELECT * FROM userstable";

        try (PreparedStatement preparedStatement = connection.prepareStatement(getAll)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");
                rslist.add(new User(name, lastName, age));
            }
            System.out.println("All users of the table \"users\" have been sent");
            return rslist;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rslist;
    }

    public void cleanUsersTable() {
        String clean = "TRUNCATE TABLE userstable";

        try (Statement statement = connection.createStatement()) {
            statement.execute(clean);
            System.out.println("Table \"users\" has been cleared");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
