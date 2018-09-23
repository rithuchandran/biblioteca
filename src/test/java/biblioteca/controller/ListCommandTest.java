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
        verify(libraryOutputDriver).println(BOOK_COLUMNS);
        verify(libraryOutputDriver).println(LINE);
        verify(libraryOutputDriver).println(book1);
        verify(libraryOutputDriver).println(book2);
        verify(libraryOutputDriver).println(book3);

    }

    @DisplayName("Should display a list of movies ")
    @Test
    void testDoActionForListingMovies() {
        Menu.LIST_MOVIES.doAction(libraryOutputDriver, libraryInputDriver, library);

        verify(libraryOutputDriver).println(MOVIE_COLUMNS);
        verify(libraryOutputDriver).println(LINE);
        verify(libraryOutputDriver).println(movie1);
        verify(libraryOutputDriver).println(movie2);
        verify(libraryOutputDriver).println(movie3);

    }
}
