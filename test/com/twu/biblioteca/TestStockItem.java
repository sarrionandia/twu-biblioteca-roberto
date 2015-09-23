package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rsarrion on 23/09/2015.
 */
public class TestStockItem {

    @Test
    public void TestCheckout() {
        LibraryStock stock = new Book("Title", "Author", 2015);
        assertTrue(stock.isAvailable());
        User user = new User("123-4567", "password");
        try {
            stock.checkOut(user);
        } catch (StockNotAvailableException e) {
            fail("Stock should initially be available");
        }

        assertEquals(user, stock.loanedTo());
        assertFalse(stock.isAvailable());
    }
}
