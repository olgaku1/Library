package by.epamtc.kulikOlga.library.controller.impl.user;

import by.epamtc.kulikOlga.library.controller.command.Command;
import by.epamtc.kulikOlga.library.service.UserService;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;
import by.epamtc.kulikOlga.library.service.factory.ServiceFactory;

public class SignOut implements Command {
    @Override
    public String execute(String request) throws ServiceException {
        String response = "End of the session";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        userService.signOut();

        return response;
    }
}
