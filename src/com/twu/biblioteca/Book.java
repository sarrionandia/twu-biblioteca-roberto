package com.twu.biblioteca;

import java.time.Year;

/**
 * Created by Tito on 18/09/2015.
 *
 * Represents a book for the Biblioteca app
 */
public class Book {
    private String title;
    private String author;
    private Year yearPublished;
    private Boolean available;

    /**
     * Constructor for Book
     * @param title The title of the Book, e.g. "Alice in Wonderland"
     * @param author The author of the Book, e.g. "Lewis Carrol"
     * @param yearPublished The year in which the book was published
     */
    public Book (String title, String author, Year yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = true;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("\"");
        output.append(title);
        output.append("\" by ");
        output.append(author);
        output.append(" [");
        output.append(yearPublished);
        output.append("]");
        return output.toString();
    }

    /**
     * Check whether or not a book is available or checked out
     * @return True if available, False if checked out
     */
    public Boolean isAvailable() {
        return available;
    }

    /**
     * Check out the book
     * @throws BookNotAvailableException If book is already checked out
     */
    public void checkOut() throws BookNotAvailableException {
        if (!this.available) {
            throw new BookNotAvailableException();
        }
        else {
            this.available = false;
        }
    }

    /**
     * Return a book that has been checked out
     * @throws BookNotOutException If a book has not yet been checked out
     */
    public void returnBook() throws BookNotOutException {
        if (this.available) {
            throw new BookNotOutException();
        }
        else {
            this.available = true;
        }
    }
}
