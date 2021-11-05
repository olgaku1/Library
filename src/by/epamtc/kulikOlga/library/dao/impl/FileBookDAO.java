package by.epamtc.kulikOlga.library.dao.impl;

import by.epamtc.kulikOlga.library.bean.Book;
import by.epamtc.kulikOlga.library.dao.exception.DAOException;
import by.epamtc.kulikOlga.library.dao.BookDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileBookDAO implements BookDAO {

    @Override
    public List<Book> viewAllBooks() throws DAOException {
        List<Book> result = new ArrayList<>();
        String book;
        try (BufferedReader reader = new BufferedReader(new FileReader("out\\resource\\Books.txt"))) {
            while ((book = reader.readLine()) != null) {
                result.add(new Book(book));
            }
        } catch (Exception e) {
            throw new DAOException("File not found");
        }
        return result;
    }

    @Override
    public void addBook(Book book) throws DAOException {
        try (FileWriter fos = new FileWriter("out\\resource\\Books.txt", true)) {
            fos.append(book.writeBookParamsToFile());
        } catch (Exception e) {
            throw new DAOException("File not found", e);
        }
    }

    @Override
    public void removeBook(Book book) throws DAOException {
        List<Book> books = viewAllBooks();
        books.remove(book);
    }

    @Override
    public List<Book> findByTitle(String title) throws DAOException {
        List<Book> result = new ArrayList<>();
        try {
            List<Book> books = viewAllBooks();
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    result.add(book);
                }
            }
        } catch (DAOException e) {
            throw new DAOException("Exception of book searching", e);
        }
        return result;
    }

    @Override
    public List<Book> findByAuthor(String author) throws DAOException {
        List<Book> result = new ArrayList<>();
        try {
            List<Book> books = viewAllBooks();
            for (Book book : books) {
                if (book.getAuthor().equals(author)) {
                    result.add(book);
                }
            }
        } catch (DAOException e) {
            throw new DAOException("Exception of book searching", e);
        }
        return result;
    }

    @Override
    public List<Book> findByGenre(String genre) throws DAOException {
        List<Book> result = new ArrayList<>();
        try {
            List<Book> books = viewAllBooks();
            for (Book book : books) {
                if (book.getGenre().equals(genre)) {
                    result.add(book);
                }
            }
        } catch (DAOException e) {
            throw new DAOException("Exception of book searching", e);
        }
        return result;
    }

    @Override
    public Book findByID(int bookID) throws DAOException {
        Book result = null;
        try {
            List<Book> books = viewAllBooks();
            for (Book book : books) {
                if (book.getBookID() == bookID) {
                    result = book;
                }
            }
        } catch (DAOException e) {
            throw new DAOException("Exception of book searching", e);
        }
        return result;
    }
}
