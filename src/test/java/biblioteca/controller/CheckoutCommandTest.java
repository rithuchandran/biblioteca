package biblioteca.controller;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.model.Book.aBook;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutCommandTest extends TestHelper {
    @DisplayName("Should call checkoutBook when user wants to checkout a book ")
    @Test
    void testDoActionForCheckout() {
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1").thenReturn("Harry Potter and the philosopher's stone");
        Menu.LOGIN.doAction(libraryOutputDriver,libraryInputDriver,library);
        Menu.CHECKOUT_BOOK.doAction(libraryOutputDriver, libraryInputDriver, library);

        verify(libraryOutputDriver).println("Enter the title of the book you want to checkout: ");
        library.getTitles(aBook());
        verify(libraryOutputDriver,never()).println("Harry Potter and the philosopher's stone");
    }
}
