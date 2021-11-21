package by.epamtc.kulikOlga.library.service;

import by.epamtc.kulikOlga.library.bean.User;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    void registration(String login, String password, String name, String surname, String userRole) throws ServiceException;

    User signIn(String login, String password) throws ServiceException;

    List<User> findAllUsers() throws ServiceException;

    void signOut() throws ServiceException;

    String checkPermission() throws ServiceException;
}
