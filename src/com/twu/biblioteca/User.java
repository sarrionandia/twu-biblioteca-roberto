package com.twu.biblioteca;

/**
 * Created by Tito on 18/09/2015.
 *
 * A user of the library
 */
public class User {

    private String libraryNumber;
    private String password;

    /**
     * Constructor
     * @param libraryNumber The library number of the user
     * @param password The password of the user
     */
    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    /**
     * Get the library number
     * @return The library number of the customer
     */
    public String getLibraryNumber() {
        return libraryNumber;
    }

    /**
     * Get the password of the user
     * @return The password
     */
    public String getPassword() {
        return this.password;
    }

}
