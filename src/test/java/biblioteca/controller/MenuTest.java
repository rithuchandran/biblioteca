package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.LibraryInputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {
    private OutputDriver libraryOutputDriver;
    private InputDriver libraryInputDriver;
    private String book1 = "";
    private String book2 = "";
    private String book3 = "";
    @BeforeEach
    void initialize() {
        libraryOutputDriver = mock(OutputDriver.class);
        libraryInputDriver = mock(LibraryInputDriver.class);
        book1 = "Harry Potter and the philosopher's stone\t\t\t\t\tJ K Rowling\t\t\t\t\t\t1997";
        book2 = "Harry Potter and the chamber of secrets\t\t\t\t\tJ K Rowling\t\t\t\t\t\t1998";
        book3 = "Harry Potter and the prisoner of azkaban\t\t\t\t\tJ K Rowling\t\t\t\t\t\t1999";
    }
    @DisplayName("Should display a list of books after displaying welcome message")
    @Test
    void testDoAction() {

        when(libraryInputDriver.getInput()).thenReturn("1");

        Menu.LIST_BOOKS.doAction(libraryOutputDriver,new Library());

        verify(libraryOutputDriver).print(book1);
        verify(libraryOutputDriver).print(book2);
        verify(libraryOutputDriver).print(book3);

    }
}
