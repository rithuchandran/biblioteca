package biblioteca.controller;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.model.Book.aBook;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutCommandTest extends TestHelper {
    @DisplayName("Should call checkoutBook when user wants to checkout a book ")
    @Test
    void testDoActionForCheckout() {
        when(libraryInputDriver.getInput()).thenReturn("Harry Potter and the philosopher's stone");

        Menu.CHECKOUT_BOOK.doAction(libraryOutputDriver, libraryInputDriver, libraryMock);

        verify(libraryOutputDriver).print("Enter the title of the book you want to checkout: ");
        verify(libraryMock).checkout(aBook().withTitle("Harry Potter and the philosopher's stone"));
    }
}
