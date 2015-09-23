package com.twu.biblioteca;

import java.util.HashMap;

/**
 * Created by rsarrion on 23/09/2015.
 *
 * Singleton class for maintaining a list of users for the library
 */
public class UserRegistry {

    private static UserRegistry instance;
    private HashMap<String, String> users;

    protected UserRegistry() {
        users = new HashMap<String, String>();
    }

    public static UserRegistry getInstance() {
        if (instance == null) {
            instance = new UserRegistry();
        }
        return instance;
    }

    /**
     * Authenticate a user of the library
     *
     * @param user      The user to be authenticated
     * @return True if valid, otherwise false.
     */
    public boolean authenticate(User user) {
        String libraryNumber = user.getLibraryNumber();
        String password = user.getPassword();
        return (users.get(libraryNumber).equals(password));
    }

    /**
     * Add a user to the registry
     * @param user The user to be added
     */
    public void addUser(User user) {
        users.put(user.getLibraryNumber(), user.getPassword());
    }
}
