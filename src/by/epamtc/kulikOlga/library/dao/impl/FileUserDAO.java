package by.epamtc.kulikOlga.library.dao.impl;

import by.epamtc.kulikOlga.library.bean.User;
import by.epamtc.kulikOlga.library.bean.UserRole;
import by.epamtc.kulikOlga.library.dao.exception.DAOException;
import by.epamtc.kulikOlga.library.dao.UserDAO;
import by.epamtc.kulikOlga.library.service.impl.CurrentUser;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUserDAO implements UserDAO {
    private final String PATH_USERS = "resource/Users.txt";
    private final String PATH_ADMIN = "resource/Admin.txt";
    private final String PATH_USER = "resource/User.txt";

    @Override
    public User signIn(String login, String password) throws DAOException {
        try {
            List<User> users = readAllUsers();
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
        try (FileWriter writer = new FileWriter(PATH_USERS, true)) {
            writer.append(newUser.userParamsToFile()).append("\n");
        } catch (IOException e) {
            throw new DAOException("File not found", e);
        }
    }

    @Override
    public List<User> readAllUsers() throws DAOException {
        List<User> result = new ArrayList<>();
        String current;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_USERS))) {
            while ((current = reader.readLine()) != null) {
                result.add(new User(current));
            }
        } catch (IOException e) {
            throw new DAOException("File not found", e);
        }
        return result;
    }

    public String checkPermission() throws DAOException{
        String command;
        StringBuilder listOfCommands = new StringBuilder();
        if (UserRole.ADMIN.equals(CurrentUser.getUserRole())) {
            try (BufferedReader reader = new BufferedReader(new FileReader(PATH_ADMIN))) {
                while ((command = reader.readLine()) != null) {
                    listOfCommands.append(command);
                }
            } catch (IOException e) {
                throw new DAOException("File not found");
            }
        } else if (UserRole.USER.equals(CurrentUser.getUserRole())){
            try (BufferedReader reader = new BufferedReader(new FileReader(PATH_USER))) {
                while ((command = reader.readLine()) != null) {
                    listOfCommands.append(command);
                }
            } catch (IOException e) {
                throw new DAOException("File not found");
            }
        }

        return listOfCommands.toString();
    }
}
