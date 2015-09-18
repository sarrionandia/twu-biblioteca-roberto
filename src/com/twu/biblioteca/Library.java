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
    private List<Movie> movieList;

    /**
     * Default constructor
     */
    public Library() {
        this.bookList = new ArrayList<Book>();
    }

    /**
     * Add a book to the library
     * @param book The book to be added
     */
    public void add(Book book) {
        bookList.add(book);
    }

    /**
     * Add a movie to the library
     * @param movie The movie to be added
     */
    public void add(Movie movie) {
        movieList.add(movie);
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

    /**
     * Get all books that have been loaned out
     * @return Every book currently on loan
     */
    public List<Book> getLoanedBookes() {
        List<Book> loanedBooks = new ArrayList<Book>();
        for (Book book : this.getBooks()) {
            if (! book.isAvailable()) {
                loanedBooks.add(book);
            }
        }
        return loanedBooks;
    }

}
