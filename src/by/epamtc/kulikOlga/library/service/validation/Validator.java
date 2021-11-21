package by.epamtc.kulikOlga.library.service.validation;

import by.epamtc.kulikOlga.library.bean.UserRole;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidTitle(String title) {
        final String REGEX = "^[\\p{L}\\s\\-_,.';:()]*$";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(title);
        return matcher.find();
    }

    public static boolean isValidAuthor(String author) {
        final String REGEX = "^[\\p{L}\\s.’\\-,()]*$";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(author);
        return matcher.find();
    }

    public static boolean isValidGenre(String genre) {
        final String REGEX = "^[\\p{L}\\s.’\\-,]*$";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(genre);
        return matcher.find();
    }

    public static boolean isValidBookID(int bookID) {
        final String REGEX = "[-+]?\\d+";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(String.valueOf(bookID));
        return matcher.find();
    }

    public static boolean isValidLogin(String login) {
        final String REGEX = "^[a-z0-9_-]{3,16}$";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(login);
        return matcher.find();
    }

    public static boolean isValidPassword(String password) {
        final String REGEX = "^[a-zA-Z0-9-_]{8,}$";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static boolean isValidName(String name) {
        final String REGEX = "^[a-zA-Z-]{3,22}$";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public static boolean isValidSurname(String surname) {
        final String REGEX = "^[a-zA-Z-]{3,22}$";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(surname);
        return matcher.find();
    }

    public static boolean isValidUserRole(String userRole) {
        return userRole.equalsIgnoreCase(UserRole.ADMIN.name()) ||
                userRole.equalsIgnoreCase(UserRole.USER.name());
    }
}
