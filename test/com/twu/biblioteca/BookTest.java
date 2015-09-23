package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by Tito on 18/09/2015.
 * JUnit tests for Book class
 */
public class BookTest {

    String TITLE = "The Death and Life of Great American Cities";
    String AUTHOR = "Jane Jacobs";
    int YEAR = 1961;

    private Book book;

    @Before
    public void setup(){
        book = new Book(TITLE, AUTHOR, YEAR);
    }

    @Test
    public void testToString(){
        String expected = "\"The Death and Life of Great American Cities\" by Jane Jacobs [1961]";
        assertEquals(expected, book.toString());
    }

    @Test
    public void testCheckOut(){
        assertTrue("Book should initially be available", book.isAvailable());
        try {
            book.checkOut();
        } catch (StockNotAvailableException e) {
            fail("Checking out the book for the first time should not throw exception");
        }
        assertFalse("Book should not be available after checkout", book.isAvailable());
    }

    @Test
    public void testDoubleCheckout() {
        //Should throw an exception if you try to check a book out twice
        try {
            book.checkOut();
            book.checkOut();
            fail("Exception should have been thrown for double checkout");
        } catch (StockNotAvailableException e) {

        }
    }
}
