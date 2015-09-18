package com.twu.biblioteca;

/**
 * Created by Tito on 18/09/2015.
 * Exception for when a book is not available
 */
public class BookNotAvailableException extends Exception {

    public BookNotAvailableException(){
        super("This book has already been checked out");
    }
}
