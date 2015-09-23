package com.twu.biblioteca;


/**
 * Created by Tito on 18/09/2015.
 *
 * Represents a book for the Biblioteca app
 */
public class Book extends LibraryStock {
    private String title;
    private String author;
    private int yearPublished;

    /**
     * Constructor for Book
     * @param title The title of the Book, e.g. "Alice in Wonderland"
     * @param author The author of the Book, e.g. "Lewis Carrol"
     * @param yearPublished The year in which the book was published
     */
    public Book (String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
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
}
