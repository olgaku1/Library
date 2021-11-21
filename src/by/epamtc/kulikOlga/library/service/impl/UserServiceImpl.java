package by.epamtc.kulikOlga.library.service.impl;

import by.epamtc.kulikOlga.library.bean.User;
import by.epamtc.kulikOlga.library.bean.UserRole;
import by.epamtc.kulikOlga.library.dao.UserDAO;
import by.epamtc.kulikOlga.library.dao.exception.DAOException;
import by.epamtc.kulikOlga.library.dao.factory.DAOFactory;
import by.epamtc.kulikOlga.library.service.UserService;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;
import by.epamtc.kulikOlga.library.service.validation.Validator;

import java.util.ArrayList;
import java.util.List;

import static by.epamtc.kulikOlga.library.service.impl.CurrentUser.isCorrectUserRole;
import static by.epamtc.kulikOlga.library.service.validation.Validator.*;

public class UserServiceImpl implements UserService {
   private Validator validator;
   private CurrentUser currentUser;

    @Override
    public void registration(String login, String password, String name, String surname, String userRole) throws ServiceException {
        if (!isValidLogin(login)) {
            throw new ServiceException("Incorrect login form");
        }
        if (!isValidPassword(password)) {
            throw new ServiceException("Incorrect password form");
        }
        if (!isValidName(name)) {
            throw new ServiceException("Incorrect name");
        }
        if (!isValidSurname(surname)) {
            throw new ServiceException("Incorrect surname");
        }
        if(!isValidUserRole(userRole)) {
            throw new ServiceException("Incorrect user role form");
        }

        if (isCorrectUserRole()) {
            User user = new User(login, password, name, surname, UserRole.valueOf(userRole.toUpperCase()));

            try {
                List<User> users = findAllUsers();
                if (!users.contains(user)) {
                    DAOFactory daoObjectFactory = DAOFactory.getInstance();
                    UserDAO userDAO = daoObjectFactory.getUserDAO();
                    userDAO.registration(user);
                } else {
                    throw new ServiceException("Such user already exists");
                }
            } catch (DAOException e) {
                throw new ServiceException("Exception of registration new user", e);
            }
        } else {
            throw new ServiceException("You do not have the correct rights");
        }
    }

    @Override
    public User signIn(String login, String password) throws ServiceException {
        if (!isValidLogin(login)) {
            throw new ServiceException("Incorrect login form");
        }
        if (!isValidPassword(password)) {
            throw new ServiceException("Incorrect password form");
        }

        User result;

        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            result = userDAO.signIn(login, password);

        } catch (DAOException e) {
            throw new ServiceException("Exception of authentication", e);
        }
        CurrentUser currentUser = new CurrentUser();
        currentUser.setUser(result);
        return result;
    }

    @Override
    public List<User> findAllUsers() throws ServiceException {
        List<User> result = new ArrayList<>();
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            result = userDAO.readAllUsers();
        } catch (DAOException e) {
            throw new ServiceException("Exception of authentication", e);
        }
        return result;
    }

    @Override
    public void signOut() throws ServiceException {
    }

    public String checkPermission() throws ServiceException {
        String result;
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            result = userDAO.checkPermission();
        } catch (DAOException e) {
            throw new ServiceException("Exception of authentication", e);
        }
        return result;
    }

}
