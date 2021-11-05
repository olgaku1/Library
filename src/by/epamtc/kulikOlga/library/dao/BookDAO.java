package by.epamtc.kulikOlga.library.dao;

import by.epamtc.kulikOlga.library.bean.Book;
import by.epamtc.kulikOlga.library.dao.exception.DAOException;

import java.util.List;

public interface BookDAO {
    void addBook(Book book) throws DAOException;
    void removeBook(Book book) throws DAOException;
    List<Book> findByTitle(String title) throws DAOException;
    List<Book> findByAuthor(String author) throws DAOException;
    List<Book> findByGenre(String genre) throws DAOException;
    Book findByID(int bookID) throws DAOException;
    List<Book> viewAllBooks() throws DAOException;
}
