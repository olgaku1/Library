package by.epamtc.kulikOlga.library.controller.command;

import by.epamtc.kulikOlga.library.service.exception.ServiceException;

public interface Command {
    public String execute(String request) throws ServiceException;
}
