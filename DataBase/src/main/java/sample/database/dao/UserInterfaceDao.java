package sample.database.dao;

import sample.database.entities.User;

import java.util.List;

public interface UserInterfaceDao {

    User getUserById(int userId, String baseName);

    List<User> getAllUsers(String baseName);

}
