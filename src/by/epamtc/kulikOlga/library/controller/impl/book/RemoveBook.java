package by.epamtc.kulikOlga.library.controller.impl.book;

import by.epamtc.kulikOlga.library.controller.command.Command;
import by.epamtc.kulikOlga.library.service.BookService;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;
import by.epamtc.kulikOlga.library.service.factory.ServiceFactory;

public class RemoveBook implements Command {
    @Override
    public String execute(String request) throws ServiceException {
        String[] arrayOfRequest = request.split("/");
        int bookID = Integer.parseInt(arrayOfRequest[1]);
        String response = "Book removed";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();

        bookService.removeBook(bookID);

        return response;
    }
}
