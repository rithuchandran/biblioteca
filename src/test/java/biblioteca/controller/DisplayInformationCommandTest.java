package biblioteca.controller;

import biblioteca.TestHelper;
import biblioteca.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DisplayInformationCommandTest extends TestHelper {

    @DisplayName("Should display user's name, email address and phone number ")
    @Test
    void testDoActionForDisplayInformation2() {
        Command command = new DisplayInformationCommand();
        command.doAction(libraryOutputDriver, libraryInputDriver, library, user);
        verify(libraryOutputDriver).println("Name: user1\nEmail address: user1@mail.com\nPhone number: 1234567891");
    }
}
