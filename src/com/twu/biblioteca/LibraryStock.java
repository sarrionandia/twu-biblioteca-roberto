package com.twu.biblioteca;

/**
 * Created by Tito on 18/09/2015.
 * Something that can be checked out of the library
 */
public abstract class LibraryStock {

    protected User loanedTo;

    /**
     * Check whether or not a book is available or checked out
     * @return True if available, False if checked out
     */
    public Boolean isAvailable() {
        return (loanedTo == null);
    }

    /**
     * Check out the stock
     * @throws StockNotAvailableException If book is already checked out
     */
    public void checkOut(User user) throws StockNotAvailableException, InvalidLoginException {

        //Check the password and library number match
        if (! UserRegistry.getInstance().authenticate(user)) {
            throw new InvalidLoginException();
        }

        if (this.isAvailable()) {
            this.loanedTo = user;
        }
        else {
            throw new StockNotAvailableException();
        }
    }

    /**
     * Return a book that has been checked out
     * @throws StockNotOutException If a book has not yet been checked out
     */
    public void returnStock() throws StockNotOutException {
        if (this.isAvailable()) {
            throw new StockNotOutException();
        }
        else {
            this.loanedTo = null;
        }
    }


    public User loanedTo() {
        return this.loanedTo;
    }

}
