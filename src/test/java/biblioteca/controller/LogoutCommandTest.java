package biblioteca.controller;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class LogoutCommandTest extends TestHelper {
    @DisplayName("should logout a logged in user")
    @Test
    void testLogout(){
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1");
        Command loginCommand = new LoginCommand();
        Command logoutCommand = new LogoutCommand();

        loginCommand.doAction(libraryOutputDriver,libraryInputDriver,library);
        assertTrue(library.isUserLoggedIn());

        logoutCommand.doAction(libraryOutputDriver,libraryInputDriver,library);
        assertFalse(library.isUserLoggedIn());
    }
}
