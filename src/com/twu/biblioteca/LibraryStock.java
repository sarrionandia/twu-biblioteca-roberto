package com.twu.biblioteca;

/**
 * Created by Tito on 18/09/2015.
 * Something that can be checked out of the library
 */
public abstract class LibraryStock {

    protected boolean available;

    /**
     * Check whether or not a book is available or checked out
     * @return True if available, False if checked out
     */
    public Boolean isAvailable() {
        return available;
    }

    /**
     * Check out the stock
     * @throws StockNotAvailableException If book is already checked out
     */
    public void checkOut() throws StockNotAvailableException {
        if (!this.available) {
            throw new StockNotAvailableException();
        }
        else {
            this.available = false;
        }
    }

    /**
     * Return a book that has been checked out
     * @throws StockNotOutException If a book has not yet been checked out
     */
    public void returnStock() throws StockNotOutException {
        if (this.available) {
            throw new StockNotOutException();
        }
        else {
            this.available = true;
        }
    }


}
