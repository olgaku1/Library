package by.epamtc.kulikOlga.library.service.impl;

import by.epamtc.kulikOlga.library.bean.User;
import by.epamtc.kulikOlga.library.bean.UserRole;

public class CurrentUser {
    private static User user;

    public CurrentUser() {
    }

    public static UserRole getUserRole() {
        return user.getUserRole();
    }

    public void setUser(User user) {
        CurrentUser.user = user;
    }

    public static boolean isCorrectUserRole() {
        boolean result = false;
        if (UserRole.ADMIN.equals(CurrentUser.getUserRole())) {
            result = true;
        }
        return result;
    }

}
