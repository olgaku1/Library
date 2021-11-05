package by.epamtc.kulikOlga.library.dao.impl;

import by.epamtc.kulikOlga.library.bean.User;
import by.epamtc.kulikOlga.library.dao.exception.DAOException;
import by.epamtc.kulikOlga.library.dao.UserDAO;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileUserDAO implements UserDAO {
    @Override
    public User signIn(String login, String password) throws DAOException {
        try {
            List<User> users = viewAllUsers();
            for (User user : users) {
                if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                    return user;
                }
            }
        } catch (DAOException e) {
            throw new DAOException("Exception of authentication", e);
        }
        return null;
    }

    @Override
    public void registration(User newUser) throws DAOException {
        try (FileWriter writer = new FileWriter("out\\resource\\Users.txt", true)) {
            writer.append(newUser.writeUserParamsToFile());
        } catch (Exception e) {
            throw new DAOException("File not found");
        }
    }

    @Override
    public List<User> viewAllUsers() throws DAOException {
        List<User> result = new ArrayList<>();
        String current;
        try (BufferedReader reader = new BufferedReader(new FileReader("out\\resource\\Users.txt"))) {
            while ((current = reader.readLine()) != null) {
                result.add(new User(current));
            }
        } catch (Exception e) {
            throw new DAOException("File not found");
        }
        return result;
    }
}
