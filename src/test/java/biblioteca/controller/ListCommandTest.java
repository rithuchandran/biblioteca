package biblioteca.controller;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.common.Constants.BOOK_COLUMNS;
import static biblioteca.common.Constants.LINE;
import static biblioteca.common.Constants.MOVIE_COLUMNS;
import static org.mockito.Mockito.verify;

public class ListCommandTest extends TestHelper {
    @DisplayName("Should display a list of books ")
    @Test
    void testDoActionForListingBooks() {
        Menu.LIST_BOOKS.doAction(libraryOutputDriver, libraryInputDriver, library);
        verify(libraryOutputDriver).print(BOOK_COLUMNS);
        verify(libraryOutputDriver).print(LINE);
        verify(libraryOutputDriver).print(book1);
        verify(libraryOutputDriver).print(book2);
        verify(libraryOutputDriver).print(book3);

    }

    @DisplayName("Should display a list of movies ")
    @Test
    void testDoActionForListingMovies() {
        Menu.LIST_MOVIES.doAction(libraryOutputDriver, libraryInputDriver, library);

        verify(libraryOutputDriver).print(MOVIE_COLUMNS);
        verify(libraryOutputDriver).print(LINE);
        verify(libraryOutputDriver).print(movie1);
        verify(libraryOutputDriver).print(movie2);
        verify(libraryOutputDriver).print(movie3);

    }
}
