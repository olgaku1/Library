package by.epamtc.kulikOlga.library.service.factory;


import by.epamtc.kulikOlga.library.service.BookService;
import by.epamtc.kulikOlga.library.service.UserService;
import by.epamtc.kulikOlga.library.service.impl.BookServiceImpl;
import by.epamtc.kulikOlga.library.service.impl.UserServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final BookService bookService = new BookServiceImpl();
    private final UserService userService = new UserServiceImpl();

    private ServiceFactory(){

    }

    public static  ServiceFactory getInstance() {
        return instance;
    }



    public BookService getBookService() {
        return bookService;
    }

    public UserService getUserService() {
        return userService;
    }
}
