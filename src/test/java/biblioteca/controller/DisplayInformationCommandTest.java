package biblioteca.controller;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DisplayInformationCommandTest extends TestHelper {

    @DisplayName("Should display user's name, email address and phone number ")
    @Test
    void testDoActionForDisplayInformation2() {
        Command command = new DisplayInformationCommand();
        Command commandLogin = new LoginCommand();
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1");

        commandLogin.doAction(libraryOutputDriver,libraryInputDriver,library);
        command.doAction(libraryOutputDriver, libraryInputDriver, library);

        verify(libraryOutputDriver).println("Name: user1\nEmail address: user1@mail.com\nPhone number: 1234567891");
    }
}
