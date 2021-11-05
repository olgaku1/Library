package by.epamtc.kulikOlga.library.controller.impl.book;

import by.epamtc.kulikOlga.library.controller.command.Command;
import by.epamtc.kulikOlga.library.service.BookService;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;
import by.epamtc.kulikOlga.library.service.factory.ServiceFactory;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AddNewBook implements Command {
    @Override
    public String execute(String request) throws ServiceException {
        String[] arrayOfRequest = request.split("/");
        System.out.println(Arrays.deepToString(arrayOfRequest));
        String title = arrayOfRequest[1];
        String author = arrayOfRequest[2];
        String genre = arrayOfRequest[3];
        String response = "Book added";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();
        bookService.addNewBook(title, author, genre);

        return response;
    }
}
