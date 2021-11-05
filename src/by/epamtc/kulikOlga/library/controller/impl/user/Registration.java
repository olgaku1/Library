package by.epamtc.kulikOlga.library.controller.impl.user;

import by.epamtc.kulikOlga.library.bean.UserRole;
import by.epamtc.kulikOlga.library.controller.command.Command;
import by.epamtc.kulikOlga.library.service.UserService;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;
import by.epamtc.kulikOlga.library.service.factory.ServiceFactory;

public class Registration implements Command {
    @Override
    public String execute(String request) throws ServiceException {
        String[] arrayOfRequest = request.split("/");
        String login = arrayOfRequest[1];
        String password = arrayOfRequest[2];
        String name = arrayOfRequest[3];
        String surname = arrayOfRequest[4];
        String userRole = arrayOfRequest[5];
        String response = "User registered";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        userService.registration(login, password, name, surname, userRole);

        return response;
    }
}
