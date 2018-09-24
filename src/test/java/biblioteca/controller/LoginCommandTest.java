package biblioteca.controller;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LoginCommandTest extends TestHelper {
    @DisplayName("should print success message for successful authenticate")
    @Test
    void testLogin() {
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1");
        Command command = new LoginCommand();

        command.doAction(libraryOutputDriver, libraryInputDriver, library);

        assertTrue(library.isUserLoggedIn());
        verify(libraryOutputDriver).println("You are now logged in");
    }

    @DisplayName("should print message for unsuccessful authenticate")
    @Test
    void testUnsuccessfulLogin() {
        when(libraryInputDriver.getInput()).thenReturn("123-4670").thenReturn("password1");
        Command command = new LoginCommand();

        command.doAction(libraryOutputDriver, libraryInputDriver, library);

        assertFalse(library.isUserLoggedIn());
        verify(libraryOutputDriver).println("Login unsuccessful! Incorrect library number/ password");
    }
}
