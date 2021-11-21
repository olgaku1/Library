package by.epamtc.kulikOlga.library.dao.impl;

import by.epamtc.kulikOlga.library.bean.Book;
import by.epamtc.kulikOlga.library.dao.exception.DAOException;
import by.epamtc.kulikOlga.library.dao.BookDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBookDAO implements BookDAO {
    private final String PATH = "resource/Books.txt";

    @Override
    public List<Book> findAllBooks() throws DAOException {
        List<Book> result = new ArrayList<>();
        String book;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            while ((book = reader.readLine()) != null) {
                result.add(new Book(book));
            }
        } catch (IOException e) {
            throw new DAOException("File not found", e);
        }
        return result;
    }

    @Override
    public void addBook(Book book) throws DAOException {
        try (FileWriter fileWriter = new FileWriter(PATH, true)) {
            fileWriter.append(book.bookParamsToFile()).append("\n");
        } catch (IOException e) {
            throw new DAOException("File not found", e);
        }
    }

    @Override
    public void removeBook(Book book) throws DAOException {
        List<Book> books = findAllBooks();
        books.remove(book);
        try (FileWriter fileWriter = new FileWriter(PATH)) {
            fileWriter.write("");
        } catch (IOException e) {
            throw new DAOException("File not found", e);
        }

        for (Book b : books) {
            addBook(b);
        }
    }

    @Override
    public List<Book> findByTitle(String title) throws DAOException {
        List<Book> result = new ArrayList<>();
        try {
            List<Book> books = findAllBooks();
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
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
            List<Book> books = findAllBooks();
            for (Book book : books) {
                if (book.getAuthor().equalsIgnoreCase(author)) {
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
            List<Book> books = findAllBooks();
            for (Book book : books) {
                if (book.getGenre().equalsIgnoreCase(genre)) {
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
            List<Book> books = findAllBooks();
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
