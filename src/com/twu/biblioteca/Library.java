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
        this.movieList = new ArrayList<Movie>();
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
        return (List<Book>) searchByAvailability(bookList, true);
    }

    /**
     * Get all books that have been loaned out
     * @return Every book currently on loan
     */
    public List<Book> getLoanedBooks() {
        return (List<Book>) searchByAvailability(bookList, false);
    }

    /**
     * Get all available movies
     * @return Every movie that has not been checked out
     */
    public List<Movie> getAvailableMovies() {
        return (List<Movie>) searchByAvailability(movieList, true);
    }

    /**
     * Get all movies that have been loaned out
     * @return Every movie currently on loan
     */
    public List<Movie> getLoanedMovies() {
        return (List<Movie>) searchByAvailability(movieList, false);
    }

    /**
     * Get all of the movies in the library
     * @return All movies
     */
    public List<Movie> getMovies() {
        return this.movieList;
    }

    /**
     * Return available or unavailable items from a list of library stock items
     */
    private List<?extends LibraryStock> searchByAvailability(List<?extends LibraryStock> list, boolean availability) {
        List<LibraryStock> items = new ArrayList<LibraryStock>();

        for (LibraryStock item : list) {
            if (item.isAvailable() == availability) {
                items.add(item);
            }
        }
        return items;
    }

}
