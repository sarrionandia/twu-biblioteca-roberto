package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rsarrion on 23/09/2015.
 * Test a stock item for the library program
 */
public class TestStockItem {

    LibraryStock stock;
    User user;

    @Before
    public void setUp() {
        stock = new Book("Title", "Author", 2015);
        user = new User("123-4567", "password");

    }


    @Test
    public void TestCheckout() {
        assertTrue(stock.isAvailable());
        try {
            stock.checkOut(user);
        } catch (StockNotAvailableException e) {
            fail("Stock should initially be available");
        } catch (InvalidLoginException e) {
            fail(e.getMessage());
        }

        assertEquals(user, stock.loanedTo());
        assertFalse(stock.isAvailable());
    }

    @Test
    public void testDoubleCheckout() {
        //Should throw an exception if you try to check a book out twice
        try {
            stock.checkOut(user);
            stock.checkOut(user);
            fail("Exception should have been thrown for double checkout");
        } catch (StockNotAvailableException e) {
            //This exception should be thrown
        } catch (InvalidLoginException e) {
            fail(e.getMessage());
        }
    }

}
