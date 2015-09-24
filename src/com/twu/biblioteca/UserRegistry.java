package com.twu.biblioteca;

import java.util.HashMap;

/**
 * Created by rsarrion on 23/09/2015.
 *
 * Singleton class for maintaining a list of users for the library
 */
public class UserRegistry {

    private static UserRegistry instance;
    private HashMap<String, User> users;

    protected UserRegistry() {
        users = new HashMap<String, User>();
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

        if (! users.containsKey(libraryNumber)) {
            return false;
        }

        String password = user.getPassword();
        return (users.get(libraryNumber).getPassword().equals(password));
    }

    public boolean authenticateLibrarian(User user) {
        return (users.containsKey(user.getLibraryNumber()) && users.get(user.getLibraryNumber()).isLibrarian());
    }

    public User getUser(String libraryNumber) {
        if (!users.containsKey(libraryNumber)) {
            return null;
        }
        else {
            return users.get(libraryNumber);
        }
    }

    /**
     * Add a user to the registry
     * @param user The user to be added
     */
    public void addUser(User user) {
        users.put(user.getLibraryNumber(), user);
    }
}
