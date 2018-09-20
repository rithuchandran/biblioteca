package biblioteca.controller;

import biblioteca.view.InputDriver;
import biblioteca.view.LibraryInputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class LibraryManagementSystemTest {
    private OutputDriver LibraryOutputDriver;
    private InputDriver LibraryInputDriver;
    private String book1 = "";
    private String book2 = "";
    private String book3 = "";


    @BeforeEach
    void initialize() {
        LibraryOutputDriver = mock(OutputDriver.class);
        LibraryInputDriver = mock(LibraryInputDriver.class);
        book1 = "Harry Potter and the philosopher's stone\t\t\t\t\tJ K Rowling\t\t\t\t\t\t1997";
        book2 = "Harry Potter and the chamber of secrets\t\t\t\t\tJ K Rowling\t\t\t\t\t\t1998";
        book3 = "Harry Potter and the prisoner of azkaban\t\t\t\t\tJ K Rowling\t\t\t\t\t\t1999";
    }

    @DisplayName("Should display a welcome message upon starting the application")
    @Test
    void testDisplayWelcomeMessage() {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(LibraryOutputDriver, LibraryInputDriver);
        when(LibraryInputDriver.getInput()).thenReturn("1");
        libraryManagementSystem.start();

        verify(LibraryOutputDriver).print("Welcome to Biblioteca!");
    }

    @Disabled
    @DisplayName("Should display a list of books after displaying welcome message")
    @Test
    void testDisplayBookList() {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(LibraryOutputDriver, LibraryInputDriver);
        when(LibraryInputDriver.getInput()).thenReturn("1");
        libraryManagementSystem.start();

        verify(LibraryOutputDriver).print("Welcome to Biblioteca!");
        verify(LibraryOutputDriver).print("\t\t\t\t\t\tTitle\t\t\t\t\t\t|\t\t\tAuthor\t\t\t|\tYear Published\t");
        verify(LibraryOutputDriver).print("-------------------------------------------------------------------------------------------------------");
        verify(LibraryOutputDriver).print(book1);
        verify(LibraryOutputDriver).print(book2);
        verify(LibraryOutputDriver).print(book3);

    }

    @DisplayName("Should display menu after welcome message")
    @Test
    void testDisplayMenu() {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(LibraryOutputDriver, LibraryInputDriver);
        when(LibraryInputDriver.getInput()).thenReturn("1");
        libraryManagementSystem.start();

        verify(LibraryOutputDriver).print("Welcome to Biblioteca!");
        verify(LibraryOutputDriver).print("Select an option");
        verify(LibraryOutputDriver).print("List Books - 1");
        verify(LibraryOutputDriver).print("Welcome to Biblioteca!");
        verify(LibraryOutputDriver).print("\t\t\t\t\t\tTitle\t\t\t\t\t\t|\t\t\tAuthor\t\t\t|\tYear Published\t");
        verify(LibraryOutputDriver).print("-------------------------------------------------------------------------------------------------------");
        verify(LibraryOutputDriver).print(book1);
        verify(LibraryOutputDriver).print(book2);
        verify(LibraryOutputDriver).print(book3);

    }

}
