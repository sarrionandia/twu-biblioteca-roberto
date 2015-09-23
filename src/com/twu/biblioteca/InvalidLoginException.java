package com.twu.biblioteca;

/**
 * Created by rsarrion on 23/09/2015.
 */
public class InvalidLoginException extends Exception {

    public InvalidLoginException() {
        super("Library number or password is incorrect");
    }

}
