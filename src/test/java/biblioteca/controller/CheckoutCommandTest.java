package biblioteca.controller;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.model.Book.aBook;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class CheckoutCommandTest extends TestHelper {

    @DisplayName("should not display a checked out book in the list of books")
    @Test
    void testCheckout() {
        Command command = new CheckoutCommand(aBook());

        command.doAction(libraryOutputDriver,libraryInputDriver,library);

        verify(libraryOutputDriver).println("Enter the title of the book you want to checkout: ");
        library.getTitles(aBook());
        verify(libraryOutputDriver,never()).println("Harry Potter and the philosopher's stone");
    }

}