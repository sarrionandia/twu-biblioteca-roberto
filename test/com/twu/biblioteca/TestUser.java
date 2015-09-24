package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tito on 18/09/2015.
 * Test the user class
 */
public class TestUser {

    User user;

    @Before
    public void setup() {
        user = new User("342-5546", "CorrectHorseBatteryStaple");
        UserRegistry.getInstance().addUser(user);
    }

    @Test
    public void testPassword() {
        assertTrue("Password did not authenticate", UserRegistry.getInstance().authenticate(user));
    }

    @Test
    public void testWrongPassword() {
        User badUser = new User(user.getLibraryNumber(), "wrongpassword");
        assertFalse("Login should fail with incorrect password", UserRegistry.getInstance().authenticate(badUser));
    }

    @Test
    public void testInvalidLibraryNumber() {
        User badUser = new User("111-1111", user.getPassword());
        assertFalse(UserRegistry.getInstance().authenticate(badUser));
    }
}
