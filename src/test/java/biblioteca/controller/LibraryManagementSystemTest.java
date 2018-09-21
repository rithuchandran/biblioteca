package biblioteca.controller;

import biblioteca.view.InputDriver;
import biblioteca.view.LibraryInputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class LibraryManagementSystemTest {
    private OutputDriver libraryOutputDriver;
    private InputDriver libraryInputDriver;
    private String book1 = "";
    private String book2 = "";
    private String book3 = "";


    @BeforeEach
    void initialize() {
        libraryOutputDriver = mock(OutputDriver.class);
        libraryInputDriver = mock(LibraryInputDriver.class);
        book1 = String.format("%-53s%-30s%-8s","Harry Potter and the philosopher's stone","J K Rowling","1997");
        book2 = String.format("%-53s%-30s%-8s","Harry Potter and the chamber of secrets","J K Rowling","1998");
        book3 = String.format("%-53s%-30s%-8s","Harry Potter and the prisoner of azkaban","J K Rowling","1999");
    }

    private void verifyBookListColumn() {
        verify(libraryOutputDriver).print("\t\t\t\t\t\tTitle\t\t\t\t\t\t|\t\t\tAuthor\t\t\t|\tYear Published\t");
        verify(libraryOutputDriver).print("-------------------------------------------------------------------" +
                "------------------------------------");
    }

    private void verifyWelcomeAndMenu() {
        verify(libraryOutputDriver).print("Welcome to Biblioteca!");
        verify(libraryOutputDriver).print("Select an option :");
        verify(libraryOutputDriver).print("Press 1 to display list of books\n" +
                "Press 2 to checkout a book\n" + "Press 3 to return a book\n" + "Press 0 to quit!\n");
    }

    @DisplayName("Should display a welcome message upon starting the application")
    @Test
    void testDisplayWelcomeMessage() {
        LibraryManagementSystem libraryManagementSystem =
                new LibraryManagementSystem(libraryOutputDriver, libraryInputDriver);
        when(libraryInputDriver.getInput()).thenReturn("0");
        libraryManagementSystem.start();
        verify(libraryOutputDriver).print("Welcome to Biblioteca!");
    }

    @DisplayName("Should display menu after welcome message")
    @Test
    void testDisplayMenu() {
        LibraryManagementSystem libraryManagementSystem =
                new LibraryManagementSystem(libraryOutputDriver, libraryInputDriver);
        when(libraryInputDriver.getInput()).thenReturn("1").thenReturn("0");
        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyBookListColumn();
        verify(libraryOutputDriver).print(book1);
        verify(libraryOutputDriver).print(book2);
        verify(libraryOutputDriver).print(book3);
    }

    @DisplayName("Should show error message for wrong option")
    @Test
    void testWrongOption() {
        LibraryManagementSystem libraryManagementSystem =
                new LibraryManagementSystem(libraryOutputDriver, libraryInputDriver);
        when(libraryInputDriver.getInput()).thenReturn("6").thenReturn("1").thenReturn("0");
        libraryManagementSystem.start();
        verifyWelcomeAndMenu();
        verifyBookListColumn();
        verify(libraryOutputDriver).print(book1);
        verify(libraryOutputDriver).print(book2);
        verify(libraryOutputDriver).print(book3);
    }

    @DisplayName("Should show updated list after checking out Harry Potter and the prisoner of azkaban")
    @Test
    void testCheckout() {
        LibraryManagementSystem libraryManagementSystem =
                new LibraryManagementSystem(libraryOutputDriver, libraryInputDriver);
        when(libraryInputDriver.getInput()).thenReturn("2").
                thenReturn("Harry Potter and the prisoner of azkaban").thenReturn("1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verify(libraryOutputDriver).print("Enter the title of the book you want to checkout: ");
        verify(libraryOutputDriver).print("Thank you! Enjoy the book");

        verifyBookListColumn();
        verify(libraryOutputDriver).print(book1);
        verify(libraryOutputDriver).print(book2);
    }

    @DisplayName("Should display message if selected book is not available")
    @Test
    void testCheckoutForUnavailableBook() {
        LibraryManagementSystem libraryManagementSystem =
                new LibraryManagementSystem(libraryOutputDriver, libraryInputDriver);
        when(libraryInputDriver.getInput()).thenReturn("2").
                thenReturn("Head first java").thenReturn("1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verify(libraryOutputDriver).print("Enter the title of the book you want to checkout: ");
        verify(libraryOutputDriver).print("That book is not available");

        verifyBookListColumn();
        verify(libraryOutputDriver).print(book1);
        verify(libraryOutputDriver).print(book2);
        verify(libraryOutputDriver).print(book3);
    }

    @DisplayName("Should add book to the library after returning")
    @Test
    void testReturn() {
        LibraryManagementSystem libraryManagementSystem =
                new LibraryManagementSystem(libraryOutputDriver, libraryInputDriver);
        when(libraryInputDriver.getInput()).thenReturn("2").
                thenReturn("Harry Potter and the prisoner of azkaban").thenReturn("3").
                thenReturn("Harry Potter and the prisoner of azkaban").thenReturn("1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();

        verify(libraryOutputDriver).print("Enter the title of the book you want to checkout: ");
        verify(libraryOutputDriver).print("Thank you! Enjoy the book");
        verify(libraryOutputDriver).print("Enter the title of the book you want to return: ");
        verifyBookListColumn();
        verify(libraryOutputDriver).print(book1);
        verify(libraryOutputDriver).print(book2);
        verify(libraryOutputDriver).print(book3);
    }

    @DisplayName("Should display success message after returning")
    @Test
    void testSuccessfulReturn() {
        LibraryManagementSystem libraryManagementSystem =
                new LibraryManagementSystem(libraryOutputDriver, libraryInputDriver);
        when(libraryInputDriver.getInput()).thenReturn("2").
                thenReturn("Harry Potter and the prisoner of azkaban").thenReturn("3").
                thenReturn("Harry Potter and the prisoner of azkaban").thenReturn("1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();

        verify(libraryOutputDriver).print("Enter the title of the book you want to checkout: ");
        verify(libraryOutputDriver).print("Thank you! Enjoy the book");

        verify(libraryOutputDriver).print("Enter the title of the book you want to return: ");
        verify(libraryOutputDriver).print("Thank you for returning the book");
        verifyBookListColumn();
        verify(libraryOutputDriver).print(book1);
        verify(libraryOutputDriver).print(book2);
        verify(libraryOutputDriver).print(book3);
    }

    @DisplayName("Should display success message after returning")
    @Test
    void testUnsuccessfulReturn() {
        LibraryManagementSystem libraryManagementSystem =
                new LibraryManagementSystem(libraryOutputDriver, libraryInputDriver);
        when(libraryInputDriver.getInput()).thenReturn("3").
                thenReturn("Harry Potter").thenReturn("1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();

        verify(libraryOutputDriver).print("Enter the title of the book you want to return: ");
        verify(libraryOutputDriver).print("That is not a valid book to return");
        verifyBookListColumn();
        verify(libraryOutputDriver).print(book1);
        verify(libraryOutputDriver).print(book2);
        verify(libraryOutputDriver).print(book3);

    }

}
