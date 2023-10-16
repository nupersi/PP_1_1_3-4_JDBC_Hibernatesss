//package jm.task.core.jdbc.dao;
//
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        String create = "CREATE TABLE IF NOT EXISTS `mydatabase`.`userstable` (\n" +
//                "  `id` BIGINT NOT NULL AUTO_INCREMENT,\n" +
//                "  `name` VARCHAR(45) ,\n" +
//                "  `lastName` VARCHAR(45) ,\n" +
//                "  `age` TINYINT ,\n" +
//                "  PRIMARY KEY (`id`));\n";
//        try (Statement statement = Util.getConnection().createStatement()) {
//            statement.execute(create);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        String drop = "DROP TABLE IF EXISTS userstable";
//        try (Statement statement = Util.getConnection().createStatement()) {
//            statement.execute(drop);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String save = "INSERT INTO userstable (name, lastName, age) VALUES (?, ?, ?)";
//        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(save)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        String remove = "DELETE FROM userstable WHERE id = id";
//        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(remove)) {
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List <User> rslist = new ArrayList<>();
//
//        String getAll = "SELECT * FROM userstable";
//
//        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(getAll)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String lastName = resultSet.getString("lastName");
//                byte age = resultSet.getByte("age");
//                rslist.add(new User(name, lastName, age));
//            }
//            return rslist;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rslist;
//    }
//
//    public void cleanUsersTable() {
//        String clean = "TRUNCATE TABLE userstable";
//
//        try (Statement statement = Util.getConnection().createStatement()) {
//            statement.execute(clean);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
