package biblioteca.controller;

import biblioteca.TestHelper;
import biblioteca.model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.common.Constants.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MenuTest extends TestHelper {


    @DisplayName("Should display a list of books ")
    @Test
    void testDoActionForListingBooks() {
        Menu.LIST_BOOKS.doAction(libraryOutputDriver, libraryInputDriver, new Library());
        verify(libraryOutputDriver).print(BOOK_COLUMNS);
        verify(libraryOutputDriver).print(LINE);
        verify(libraryOutputDriver).print(book1);
        verify(libraryOutputDriver).print(book2);
        verify(libraryOutputDriver).print(book3);

    }

    @DisplayName("Should call checkoutBook when user wants to checkout a book ")
    @Test
    void testDoActionForCheckout() {
        when(libraryInputDriver.getInput()).thenReturn("Harry Potter and the philosopher's stone");

        Menu.CHECKOUT_BOOK.doAction(libraryOutputDriver, libraryInputDriver, library);

        verify(libraryOutputDriver).print("Enter the title of the book you want to checkout: ");
        verify(library).checkout("Harry Potter and the philosopher's stone");
    }

    @DisplayName("Should call returnBook when user wants to checkout a book ")
    @Test
    void testDoActionForReturn() {
        when(libraryInputDriver.getInput()).thenReturn("Harry Potter and the philosopher's stone");

        Menu.RETURN_BOOK.doAction(libraryOutputDriver, libraryInputDriver, library);

        verify(library).returnBook("Harry Potter and the philosopher's stone");
    }

    @DisplayName("Should display a list of movies ")
    @Test
    void testDoActionForListingMovies() {
        Menu.LIST_MOVIES.doAction(libraryOutputDriver, libraryInputDriver, new Library());

        verify(libraryOutputDriver).print(MOVIE_COLUMNS);
        verify(libraryOutputDriver).print(LINE);
        verify(libraryOutputDriver).print(movie1);
        verify(libraryOutputDriver).print(movie2);
        verify(libraryOutputDriver).print(movie3);

    }

}
