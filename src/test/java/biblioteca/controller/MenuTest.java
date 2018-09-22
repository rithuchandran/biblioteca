package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.LibraryInputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.common.Constants.*;
import static org.mockito.Mockito.*;

class MenuTest {
    private OutputDriver libraryOutputDriver;
    private InputDriver libraryInputDriver;
    private Library library;
    private String book1 = "";
    private String book2 = "";
    private String book3 = "";
    private String movie1 = "";
    private String movie2 = "";
    private String movie3 = "";


    @BeforeEach
    void initialize() {
        libraryOutputDriver = mock(OutputDriver.class);
        libraryInputDriver = mock(LibraryInputDriver.class);
        library = mock(Library.class);
        book1 = String.format("%-55s%-35s%-10s", "Harry Potter and the philosopher's stone", "J K Rowling", "1997");
        book2 = String.format("%-55s%-35s%-10s", "Harry Potter and the chamber of secrets", "J K Rowling", "1998");
        book3 = String.format("%-55s%-35s%-10s", "Harry Potter and the prisoner of azkaban", "J K Rowling", "1999");
        movie1 = String.format("%-55s%-35s%-10s%-10s", "Up", "Peter Docter,Bob Peterson", 2009, 8.3);
        movie2 = String.format("%-55s%-35s%-10s%-10s", "Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9);
        movie3 = String.format("%-55s%-35s%-10s%-10s", "Wreck-It Ralph", "Rick Moore", 2012, 7.8);
    }

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
