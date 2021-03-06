package by.epamtc.kulikOlga.library.controller.impl.book;

import by.epamtc.kulikOlga.library.controller.command.Command;
import by.epamtc.kulikOlga.library.service.BookService;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;
import by.epamtc.kulikOlga.library.service.factory.ServiceFactory;

public class FindByGenre implements Command {
    @Override
    public String execute(String request) throws ServiceException {
        String[] arrayOfRequest = request.split("/");
        String genre = arrayOfRequest[1];
        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();

        response = "Found books:\n" + bookService.findBookByGenre(genre);

        return response;
    }
}
