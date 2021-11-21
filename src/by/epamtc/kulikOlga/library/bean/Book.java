package by.epamtc.kulikOlga.library.bean;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 8759798872078100314L;

    private static final String DIVIDER = "/";

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
        String[] parameters = bookParameters.split(DIVIDER);
        bookID = Integer.parseInt(parameters[0]);
        title = parameters[1];
        author = parameters[2];
        genre = parameters[3];
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

    public StringBuilder bookParamsToFile() {
        StringBuilder book = new StringBuilder();
        book.append(bookID).append(DIVIDER)
                .append(title).append(DIVIDER)
                .append(author).append(DIVIDER)
                .append(genre);
        return book;
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
