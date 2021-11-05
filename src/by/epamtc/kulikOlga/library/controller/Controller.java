package by.epamtc.kulikOlga.library.controller;

import by.epamtc.kulikOlga.library.controller.command.Command;
import by.epamtc.kulikOlga.library.controller.CommandProvider;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    private final String paramDelimiter = "/";


    public String executeTask(String request) throws ServiceException {
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(paramDelimiter));
        executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request);
        return response;
    }


}
