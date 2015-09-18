package com.twu.biblioteca;

/**
 * Created by Tito on 18/09/2015.
 * Exception for books that are not checked out
 */
public class BookNotOutException extends Exception {
    public BookNotOutException() {
        super("Checked out books cannot be returned");
    }
}
