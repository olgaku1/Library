package by.epamtc.kulikOlga.library.service;

import by.epamtc.kulikOlga.library.bean.User;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    boolean isAdmin(User user) throws ServiceException;

    void registration(String login, String password, String name, String surname, String userRole) throws ServiceException;

    User signIn(String login, String password) throws ServiceException;

    List<User> viewAllUsers() throws ServiceException;

    void signOut() throws ServiceException;
}
