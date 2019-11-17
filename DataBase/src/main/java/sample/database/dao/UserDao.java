package sample.database.dao;

import sample.database.entities.User;
import sample.database.sql.ComunicationWithBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserInterfaceDao{

    /**
     * This method provide data for user object from database by id.
     * @param userId provide user id.
     * @param baseName provide name of base where user is.
     */
    public User getUserById(int userId, String baseName){
        Connection connection = ComunicationWithBase.connect(baseName);
        try(Statement statment = connection.createStatement()){
            ResultSet resultSets = statment.executeQuery("SELECT * FROM users WHERE userId=" + userId);
            if(resultSets.next()){
                User user = new User();
                user.setUserId(resultSets.getInt("userId"));
                user.setLogin(resultSets.getString("login"));
                user.setName(resultSets.getString("name"));
                user.setAge(resultSets.getInt("age"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * This method provide list of USER object.
     * @param baseName provide name of base where user is.
     */
    @Override
    public List<User> getAllUsers(String baseName) {
        Connection connection = ComunicationWithBase.connect(baseName);
        try(Statement statment = connection.createStatement()){
            List<User>users = new ArrayList<>();
                ResultSet resultSets = statment.executeQuery("SELECT * FROM users");
                while (resultSets.next()) {
                    User user = new User();
                    user.setUserId(resultSets.getInt("userId"));
                    user.setLogin(resultSets.getString("login"));
                    user.setName(resultSets.getString("name"));
                    user.setAge(resultSets.getInt("age"));
                    users.add(user);
                }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
