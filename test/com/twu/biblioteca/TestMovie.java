package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.*;

/**
 * Created by Tito on 18/09/2015.
 *
 * Test the movie class
 */
public class TestMovie {

    Movie movie;

    @Before
    public void setup() {
        try{
            movie = new Movie("Titanic", Year.of(1996), "James Cameron", 7);
        } catch (IllegalArgumentException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConstructorException() {
        try {
            Movie movie = new Movie("Titanic", Year.of(1996), "James Cameron", 14);
            fail("Rating out of bounds should throw exception");
        } catch (IllegalArgumentException e) {
        }

    }

    @Test
    public void testToString() {
        final String expected = "Titanic 1996. (James Cameron) 7/10";
        assertEquals(expected, movie.toString());
    }
}
