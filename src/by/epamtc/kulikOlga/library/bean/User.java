package by.epamtc.kulikOlga.library.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Serializable {
    private static final long serialVersionUID = -4136768725941180570L;
    private static final String DIVIDER = "/";
    private static final String DOUBLE_DIVIDER = "//";


    private String login;
    private String password;
    private String name;
    private String surname;
    private UserRole userRole;

    public User() {

    }

    public User(String login, String password, String name, String surname, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.userRole = userRole;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String userParameters) {
        Pattern pattern = Pattern.compile(DIVIDER + "\\w+" + DIVIDER);
        Matcher matcher = pattern.matcher(userParameters);

        List<String> parameters = new ArrayList<>();
        while (matcher.find()) {
            parameters.add(matcher.group(0).substring(1, matcher.group(0).length() - 1));
        }
        login = parameters.get(0);
        password = parameters.get(1);
        name = parameters.get(2);
        surname = parameters.get(3);
        userRole = UserRole.valueOf(parameters.get(4));
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String writeUserParamsToFile() {

        return DIVIDER + login + DOUBLE_DIVIDER +
                password + DOUBLE_DIVIDER +
                name + DOUBLE_DIVIDER +
                surname + DOUBLE_DIVIDER +
                userRole.toString() + DIVIDER + "\n";
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;

        if (null == login) {
            return (login == user.login);
        } else {
            if (!login.equals(user.login)) {
                return false;
            }
        }
        if (null == password) {
            return (password == user.password);
        } else {
            if (!password.equals(user.password)) {
                return false;
            }
        }
        if (null == userRole) {
            return (userRole == user.userRole);
        } else {
            if (!userRole.equals(user.userRole)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int primeNumber = 17;
        int result = 1;
        result = primeNumber * result + ((null == login) ? 0 : login.hashCode());
        result = primeNumber * result + ((null == password) ? 0 : password.hashCode());
        result = primeNumber * result + ((null == userRole) ? 0 : userRole.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole.toString() + '\'' +
                '}';
    }
}
