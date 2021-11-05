package by.epamtc.kulikOlga.library.service;

import by.epamtc.kulikOlga.library.bean.Book;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;

import java.util.List;

public interface BookService {
    void addNewBook(String title, String author, String genre) throws ServiceException;
    List<Book> findBookByTitle(String title) throws ServiceException;
    List<Book> findBookByAuthor(String author) throws ServiceException;
    List<Book> findBookByGenre(String genre) throws ServiceException;
    Book findBookByID(int bookID) throws ServiceException;
    void removeBook(int bookID) throws ServiceException;
    void  editBook(int bookID, String newTitle, String newAuthor, String newGenre) throws ServiceException;
    List<Book> viewAllBooks() throws ServiceException;

}
