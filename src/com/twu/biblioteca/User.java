package com.twu.biblioteca;

/**
 * Created by Tito on 18/09/2015.
 *
 * A user of the library
 */
public class User {

    private String libraryNumber;
    private String password;
    private boolean isLibrarian;
    private String name;
    private String email;
    private String phone;

    /**
     * Constructor
     * @param libraryNumber The library number of the suer
     * @param password The password of the user
     * @param isLibrarian Whether or not the user is a librarian
     */
    public User(String libraryNumber, String password, boolean isLibrarian) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.isLibrarian = isLibrarian;

    }

    /**
     * Constructor
     * @param libraryNumber The library number of the user
     * @param password The password of the user
     */
    public User(String libraryNumber, String password) {
        this(libraryNumber, password, false);
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

    /**
     * Check if the user is a librarian
     * @return Whether or not the user is a librarian
     */
    public boolean isLibrarian() { return this.isLibrarian; }

    public String toString() {
        return libraryNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
