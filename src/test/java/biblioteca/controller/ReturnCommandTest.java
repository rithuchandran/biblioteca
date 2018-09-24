package biblioteca.controller;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.model.Book.aBook;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReturnCommandTest extends TestHelper {
    @DisplayName("Should call returnObject when user wants to checkout a book ")
    @Test
    void testDoActionForReturn() {
        when(libraryInputDriver.getInput()).thenReturn("Harry Potter");
        Command command = new ReturnCommand(aBook());

        command.doAction(libraryOutputDriver,libraryInputDriver,library);
        verify(libraryOutputDriver).println("Enter the title of the book you want to return: ");
        verify(libraryOutputDriver).println("That is not a valid book to return");
    }
}
