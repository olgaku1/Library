package by.epamtc.kulikOlga.library.service.impl;

import by.epamtc.kulikOlga.library.bean.Book;
import by.epamtc.kulikOlga.library.bean.User;
import by.epamtc.kulikOlga.library.bean.UserRole;
import by.epamtc.kulikOlga.library.dao.BookDAO;
import by.epamtc.kulikOlga.library.dao.exception.DAOException;
import by.epamtc.kulikOlga.library.dao.factory.DAOFactory;
import by.epamtc.kulikOlga.library.service.BookService;
import by.epamtc.kulikOlga.library.service.exception.ServiceException;
import by.epamtc.kulikOlga.library.service.validation.Validator;

import java.util.ArrayList;
import java.util.List;

import static by.epamtc.kulikOlga.library.service.impl.CurrentUser.isCorrectUserRole;
import static by.epamtc.kulikOlga.library.service.validation.Validator.*;


public class BookServiceImpl implements BookService {
    private CurrentUser currentUser;
    private Validator validator = new Validator();


    @Override
    public void addNewBook(String title, String author, String genre) throws ServiceException {
        if (!validator.isValidTitle(title)) {
            throw new ServiceException("Incorrect title");
        }
        if (!validator.isValidAuthor(author)) {
            throw new ServiceException("Incorrect name of author");
        }
        if (!validator.isValidGenre(genre)) {
            throw new ServiceException("Incorrect name of genre");
        }
        if (isCorrectUserRole()) {
            Book book = new Book(title, author, genre);
            book.setBookID(book.hashCode());

            try {
                DAOFactory daoObjectFactory = DAOFactory.getInstance();
                BookDAO bookDAO = daoObjectFactory.getBookDAO();
                bookDAO.addBook(book);
            } catch (DAOException e) {
                throw new ServiceException("Exception of adding a new book", e);
            }
        } else {
            throw new ServiceException("You do not have the correct rights");
        }
    }

    @Override
    public List<Book> findBookByTitle(String title) throws ServiceException {
        if (!validator.isValidTitle(title)) {
            throw new ServiceException("Incorrect title");
        }
        List<Book> result = new ArrayList<>();
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            BookDAO bookDAO = daoObjectFactory.getBookDAO();
            result = bookDAO.findByTitle(title);
        } catch (DAOException e) {
            throw new ServiceException("Exception of searching book", e);
        }
        return result;
    }

    @Override
    public List<Book> findBookByAuthor(String author) throws ServiceException {
        if (!validator.isValidAuthor(author)) {
            throw new ServiceException("Incorrect name of author");
        }
        List<Book> result = new ArrayList<>();
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            BookDAO bookDAO = daoObjectFactory.getBookDAO();
            result = bookDAO.findByAuthor(author);
        } catch (DAOException e) {
            throw new ServiceException("Exception of searching book", e);
        }
        return result;
    }

    @Override
    public List<Book> findBookByGenre(String genre) throws ServiceException {
        if (!validator.isValidGenre(genre)) {
            throw new ServiceException("Incorrect name of genre");
        }
        List<Book> result = new ArrayList<>();
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            BookDAO bookDAO = daoObjectFactory.getBookDAO();
            result = bookDAO.findByGenre(genre);
        } catch (DAOException e) {
            throw new ServiceException("Exception of searching book", e);
        }
        return result;
    }

    @Override
    public Book findBookByID(int bookID) throws ServiceException {
        if (!isValidBookID(bookID)) {
            throw new ServiceException("Incorrect id form");
        }
        Book result = null;
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            BookDAO bookDAO = daoObjectFactory.getBookDAO();
            result = bookDAO.findByID(bookID);
        } catch (DAOException e) {
            throw new ServiceException("Exception of searching book", e);
        }
        return result;
    }

    @Override
    public void removeBook(int bookID) throws ServiceException {
        if (!isValidBookID(bookID)) {
            throw new ServiceException("Incorrect id form");
        }
        if (isCorrectUserRole()) {
            Book book = findBookByID(bookID);
            try {
                DAOFactory daoObjectFactory = DAOFactory.getInstance();
                BookDAO bookDAO = daoObjectFactory.getBookDAO();
                bookDAO.removeBook(book);
            } catch (DAOException e) {
                throw new ServiceException("Exception of removing book", e);
            }
        } else {
            throw new ServiceException("You do not have the correct rights");
        }

    }

    @Override
    public List<Book> findAllBooks() throws ServiceException {
        List<Book> result;
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            BookDAO bookDAO = daoObjectFactory.getBookDAO();
            result = bookDAO.findAllBooks();

        } catch (DAOException e) {
            throw new ServiceException("Exception of reading all books", e);
        }
        return result;
    }

    @Override
    public void editBook(int bookID, String newTitle, String newAuthor, String newGenre) throws ServiceException {
        if (!isValidBookID(bookID)) {
            throw new ServiceException("Incorrect id form");
        }
        if (!validator.isValidTitle(newTitle)) {
            throw new ServiceException("Incorrect title");
        }
        if (!validator.isValidAuthor(newAuthor)) {
            throw new ServiceException("Incorrect author name");
        }
        if (!validator.isValidGenre(newGenre)) {
            throw new ServiceException("Incorrect name of genre");
        }
        if (isCorrectUserRole()) {
            Book book = findBookByID(bookID);
            Book newBook = new Book(newTitle, newAuthor, newGenre);

            try {
                DAOFactory daoObjectFactory = DAOFactory.getInstance();
                BookDAO bookDAO = daoObjectFactory.getBookDAO();
                bookDAO.removeBook(book);
                addNewBook(newTitle, newAuthor, newGenre);
            } catch (DAOException e) {
                throw new ServiceException("Exception of editing book", e);
            }
        } else {
            throw new ServiceException("You do not have the correct rights");
        }
    }
}
