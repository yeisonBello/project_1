package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

void registerUser(User user);
void login(String email, String password);


}
