package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tito on 18/09/2015.
 * Test the Library class
 */
public class LibraryTest {

    private Library library;

    @Before
    public void setUp(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Pride and Prejudice", "Jane Austen", Year.of(1813)));
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", Year.of(1960)));
        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", Year.of(1925)));
        bookList.add(new Book("Frankenstein", "Mary Shelley", Year.of(1818)));

        library = new Library(bookList);
    }

    @Test
    public void testConstructors(){
        assertEquals(4, library.getBooks().size());
        assertEquals(0, new Library().getBooks().size());
    }

    @Test
    public void testAvailableBooks(){
        int nBooks = library.getBooks().size();
        try {
            library.getBooks().get(0).checkOut();

            //After one book has been checked out the size of the list should be 1 smaller
            assertEquals(nBooks-1, library.getAvailableBooks().size());
        } catch (BookNotAvailableException e) {
            fail("Book should not initially be checked out");
        }
    }

    @Test
    public void testCheckoutReturn() {
        Book book = library.getBooks().get(0);

        try {
            book.checkOut();
        } catch (BookNotAvailableException e) {
            fail(e.getMessage());
        }

        assertFalse("Checked out book should not be in available books", library.getAvailableBooks().contains(book));
        assertTrue("Checked out book should be in loaned books", library.getLoanedBookes().contains(book));

        try {
            book.returnBook();
        } catch (BookNotOutException e) {
            fail(e.getMessage());
        }

        assertTrue("Returned book should be in available books", library.getAvailableBooks().contains(book));
        assertFalse("Returned book should not be in loaned books", library.getLoanedBookes().contains(book));
    }
}
