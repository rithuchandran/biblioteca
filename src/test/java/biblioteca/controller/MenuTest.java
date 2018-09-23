package biblioteca.controller;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.common.Constants.BOOK_COLUMNS;
import static biblioteca.common.Constants.LINE;
import static biblioteca.model.Book.aBook;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MenuTest extends TestHelper {
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

    @DisplayName("Should display a list of books ")
    @Test
    void testDoActionForListingBooks() {
        Menu.LIST_BOOKS.doAction(libraryOutputDriver, libraryInputDriver, library);

        verify(libraryOutputDriver).println(BOOK_COLUMNS);
        verify(libraryOutputDriver).println(LINE);
        verify(libraryOutputDriver).println(book1);
        verify(libraryOutputDriver).println(book2);
        verify(libraryOutputDriver).println(book3);

    }
    @DisplayName("should print success message for successful login")
    @Test
    void testLogin(){
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1");

        Menu.LOGIN.doAction(libraryOutputDriver,libraryInputDriver,library);

        assertTrue(library.isLoggedIn(user));
        verify(libraryOutputDriver).println("You are now logged in");
    }
    @DisplayName("Should call returnObject when user wants to checkout a book ")
    @Test
    void testDoActionForReturn() {
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1").thenReturn("Harry Potter and the philosopher's stone");
        Menu.LOGIN.doAction(libraryOutputDriver,libraryInputDriver,library);

        Menu.RETURN_BOOK.doAction(libraryOutputDriver, libraryInputDriver, library);

        verify(libraryOutputDriver).println("You are now logged in");
        verify(libraryOutputDriver).println("Enter the title of the book you want to return: ");
    }
    @DisplayName("Should display user's name, email address and phone number ")
    @Test
    void testDoActionForDisplayInformation() {
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1");
        Menu.LOGIN.doAction(libraryOutputDriver, libraryInputDriver, library);
        Menu.DISPLAY_INFORMATION.doAction(libraryOutputDriver, libraryInputDriver, library);
        verify(libraryOutputDriver).println("Name: user1\nEmail address: user1@mail.com\nPhone number: 1234567891");
    }
}
