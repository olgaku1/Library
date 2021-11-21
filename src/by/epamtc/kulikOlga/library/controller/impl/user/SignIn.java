package by.epamtc.kulikOlga.library.controller.impl.user;

import by.epamtc.kulikOlga.library.controller.command.Command;
import by.epamtc.kulikOlga.library.service.UserService;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;
import by.epamtc.kulikOlga.library.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) throws ServiceException {
        String[] arrayOfRequest = request.split("/");
        String login = arrayOfRequest[1];
        String password = arrayOfRequest[2];

        String welcomeMessage = "Welcome, " + login + "!";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        userService.signIn(login, password);
        String listOfCommands = userService.checkPermission();
        String response = welcomeMessage + "\nCommands that you can execute:\n" + listOfCommands;
        return response;
    }
}
