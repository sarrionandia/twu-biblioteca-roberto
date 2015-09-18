package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.time.Year;

/**
 * Created by Tito on 18/09/2015.
 * JUnit tests for Book class
 */
public class BookTest {

    String TITLE = "The Death and Life of Great American Cities";
    String AUTHOR = "Jane Jacobs";
    Year YEAR = Year.of(1961);

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
}
