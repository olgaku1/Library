package by.epamtc.kulikOlga.library.controller.impl.book;

import by.epamtc.kulikOlga.library.controller.command.Command;
import by.epamtc.kulikOlga.library.service.BookService;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;
import by.epamtc.kulikOlga.library.service.factory.ServiceFactory;

public class EditBook implements Command {
    @Override
    public String execute(String request) throws ServiceException {
        String[] arrayOfRequest = request.split("/");
        int bookID = Integer.parseInt(arrayOfRequest[1]);
        String newTitle = arrayOfRequest[2];
        String newAuthor = arrayOfRequest[3];
        String newGenre = arrayOfRequest[4];
        String response = "Book edited";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();

        bookService.editBook(bookID, newTitle, newAuthor, newGenre);

        return response;
    }
}
