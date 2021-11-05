package by.epamtc.kulikOlga.library.dao;

import by.epamtc.kulikOlga.library.bean.User;
import by.epamtc.kulikOlga.library.dao.exception.DAOException;

import java.util.List;

public interface UserDAO {
    User signIn(String login, String password) throws DAOException;
    void registration(User newUser) throws DAOException;
    List<User> viewAllUsers() throws DAOException;

}
