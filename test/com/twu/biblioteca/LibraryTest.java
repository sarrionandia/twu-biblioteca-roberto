package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tito on 18/09/2015.
 * Test the Library class
 */
public class LibraryTest {

    private Library library;

    @Before
    public void setUp(){
        library = new Library();

        //Add books
        library.add(new Book("Pride and Prejudice", "Jane Austen", 1813));
        library.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        library.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1922));
        library.add(new Book("Frankenstein", "Mary Shelley", 1818));

        library.add(new Movie("The Godfather", 1972, "Francis Ford Coppola", 9));
        library.add(new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 10));
        library.add(new Movie("Sharktopus", 2006, "Declan O'Brien", 1));
        library.add(new Movie("Scooby Doo", 2002, "Raja Gosnell", 0));

    }

    @Test
    public void testConstructor(){
        assertEquals(4, library.getBooks().size());
        assertEquals(0, new Library().getBooks().size());
        assertEquals(4, library.getMovies().size());
        assertEquals(0, new Library().getMovies().size());

    }

    @Test
    public void testAvailableBooks(){
        int nBooks = library.getBooks().size();
        try {
            library.getBooks().get(0).checkOut();

            //After one book has been checked out the size of the list should be 1 smaller
            assertEquals(nBooks-1, library.getAvailableBooks().size());
        } catch (StockNotAvailableException e) {
            fail("Book should not initially be checked out");
        }
    }

    @Test
    public void testCheckoutReturn() {
        Book book = library.getBooks().get(0);

        try {
            book.checkOut();
        } catch (StockNotAvailableException e) {
            fail(e.getMessage());
        }

        assertFalse("Checked out book should not be in available books", library.getAvailableBooks().contains(book));
        assertTrue("Checked out book should be in loaned books", library.getLoanedBooks().contains(book));

        try {
            book.returnStock();
        } catch (StockNotOutException e) {
            fail(e.getMessage());
        }

        assertTrue("Returned book should be in available books", library.getAvailableBooks().contains(book));
        assertFalse("Returned book should not be in loaned books", library.getLoanedBooks().contains(book));

        Movie movie = library.getMovies().get(0);
        try {
            movie.checkOut();
        } catch (StockNotAvailableException e) {
            fail(e.getMessage());
        }

        assertFalse("Checked out movie should not be in available movies", library.getAvailableMovies().contains(movie));
        assertTrue("Checked out movie should be in loaned movies", library.getLoanedMovies().contains(movie));

        try {
            movie.returnStock();
        } catch (StockNotOutException e) {
            fail(e.getMessage());
        }

        assertTrue("Returned movie should be in available movies", library.getAvailableMovies().contains(movie));
        assertFalse("Returned movie should not be in loaned movies", library.getLoanedMovies().contains(movie));


    }
}
