package by.epamtc.kulikOlga.library.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book implements Serializable {
    private static final long serialVersionUID = 8759798872078100314L;

    private static final String DIVIDER = "/";
    private static final String DOUBLE_DIVIDER = "//";

    private int bookID;
    private String title;
    private String author;
    private String genre;

    public Book() {

    }

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(int bookID, String title, String author, String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(String bookParameters) {
        Pattern pattern = Pattern.compile(DIVIDER + "\\w+" + DIVIDER);
        Matcher matcher = pattern.matcher(bookParameters);

        List<String> parameters = new ArrayList<>();
        while (matcher.find()) {
            parameters.add(matcher.group(0).substring(1, matcher.group(0).length() - 1));
        }
        bookID = Integer.parseInt(parameters.get(0));
        title = parameters.get(1);
        author = parameters.get(2);
        genre = parameters.get(3);
    }

    public long getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String writeBookParamsToFile() {
        return DIVIDER + bookID + DOUBLE_DIVIDER +
                title + DOUBLE_DIVIDER +
                author + DOUBLE_DIVIDER +
                genre + DIVIDER + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        if (bookID != book.bookID) {
            return false;
        }
        if (null == title) {
            return (title == book.title);
        } else {
            if (!title.equals(book.title)) {
                return false;
            }
        }
        if (null == author) {
            return (author == book.author);
        } else {
            if (!author.equals(book.author)) {
                return false;
            }
        }
        if (null == genre) {
            return (genre == book.genre);
        } else {
            if (!genre.equals(book.genre)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int primeNumber = 17;
        int result = 1;
        result = (int) (primeNumber * bookID + ((null == title) ? 0 : title.hashCode()));
        result = primeNumber * result + ((null == author) ? 0 : author.hashCode());
        result = primeNumber * result + ((null == genre) ? 0 : genre.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{bookID=" + bookID +
                ", name='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
