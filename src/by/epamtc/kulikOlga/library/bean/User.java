package by.epamtc.kulikOlga.library.bean;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -4136768725941180570L;
    private static final String DIVIDER = "/";


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
        String[] parameters = userParameters.split(DIVIDER);

        this.login = parameters[0];
        this.password = parameters[1];
        this.name = parameters[2];
        surname = parameters[3];
        userRole = UserRole.valueOf(parameters[4].toUpperCase());
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

    public StringBuilder userParamsToFile() {
        StringBuilder user = new StringBuilder();
        user.append(login).append(DIVIDER)
                .append(password).append(DIVIDER)
                .append(name).append(DIVIDER)
                .append(surname).append(DIVIDER)
                .append(userRole.name());

        return user;
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
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", userRole='" + userRole.name() + '\'' +
                '}';
    }
}
