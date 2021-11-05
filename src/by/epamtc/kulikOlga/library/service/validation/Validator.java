package by.epamtc.kulikOlga.library.service.validation;

import by.epamtc.kulikOlga.library.bean.UserRole;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidTitle(String title) {
        String regex = "^[\\p{L}\\s.’\\-,]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(title);
        return matcher.find();
    }

    public static boolean isValidAuthor(String author) {
        String regex = "^[\\p{L}\\s.’\\-,]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(author);
        return matcher.find();
    }

    public static boolean isValidGenre(String genre) {
        String regex = "^[\\p{L}\\s.’\\-,]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(genre);
        return matcher.find();
    }

    public static boolean isValidBookID(int bookID) {
        String regex = "^[0-9]$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(String.valueOf(bookID));
        return matcher.find();
    }

    public static boolean isValidLogin(String login) {
        String regex = "^[a-z0-9_-]{3,16}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(login);
        return matcher.find();
    }

    public static boolean isValidPassword(String password) {
        String regex = "^[a-zA-Z0-9-_]{8,}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static boolean isValidName(String name) {
        String regex = "^[a-zA-Z-]{3,22}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public static boolean isValidSurname(String surname) {
        String regex = "^[a-zA-Z-]{3,22}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(surname);
        return matcher.find();
    }

    public static boolean isValidUserRole(String userRole) {
        return Objects.equals(userRole.toUpperCase(), UserRole.ADMIN) ||
                Objects.equals(userRole.toUpperCase(), UserRole.USER);
    }
}
