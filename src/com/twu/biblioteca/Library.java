package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tito on 18/09/2015.
 *
 * Contains a list of all books
 */
public class Library {
    private List<Book> bookList;

    /**
     * Default constructor
     */
    public Library() {
        this.bookList = new ArrayList<Book>();
    }

    /**
     * Constructor with initial list of books
     * @param initialBooks Books that the library should contain
     */
    public Library(List<Book> initialBooks) {
        this.bookList = new ArrayList<Book>();
        this.bookList.addAll(initialBooks);
    }

    /**
     * Get a list of all books
     * @return A list of every book in the library
     */
    public List<Book> getBooks(){
        return this.bookList;
    }

    /**
     * Get all available books
     * @return Every book that has not been checked out
     */
    public List<Book> getAvailableBooks(){
        List<Book> availableBooks = new ArrayList<Book>();
        for (Book book : this.getBooks()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }



}
