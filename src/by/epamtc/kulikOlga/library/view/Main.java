package by.epamtc.kulikOlga.library.view;


import by.epamtc.kulikOlga.library.controller.Controller;
import by.epamtc.kulikOlga.library.controller.command.Command;
import by.epamtc.kulikOlga.library.controller.command.CommandName;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;


import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String request;
        String response;
        System.out.println("Hello! To work with the electronic library, you need to log in");
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        do {
            request = scanner.nextLine();
            try {
                response = controller.executeTask(request);
            } catch (ServiceException e) {
                response = e.getMessage();
            }
            System.out.println(response);
        } while (!response.equals("End of the session"));



    }
}
