package biblioteca.controller;

import biblioteca.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class LibraryManagementSystemTest extends TestHelper {
    private LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void initialise() {
        libraryManagementSystem = new LibraryManagementSystem(libraryOutputDriver, libraryInputDriver, libraryObjects);
    }

    private void verifyWelcomeAndMenu() {
        verify(libraryOutputDriver).print("Welcome to Biblioteca!");
        verify(libraryOutputDriver).print("Select an option :");
        verify(libraryOutputDriver).print("Press 1 to display list of books\n" +
                "Press 2 to checkout a book\n" + "Press 3 to return a book\n" + "Press 4 to display list of movies\n" + "Press 0 to quit!\n");
    }

    private void verifyBookListColumn() {
        verify(libraryOutputDriver).print(String.format("%-55s%-35s%-10s", "Title", "Author", "Year Published"));
        verify(libraryOutputDriver).print("------------------------------------------------------------------------------------------------------------- ");
    }

    private void verifyMovieListColumn() {
        verify(libraryOutputDriver).print(String.format("%-55s%-35s%-10s%-10s", "Title", "Director", "Year", "Rating"));
        verify(libraryOutputDriver).print("------------------------------------------------------------------------------------------------------------- ");
    }

    @DisplayName("Should display a welcome message upon starting the application")
    @Test
    void testDisplayWelcomeMessage() {
        when(libraryInputDriver.getInput()).thenReturn("0");
        libraryManagementSystem.start();
        verify(libraryOutputDriver).print("Welcome to Biblioteca!");
    }

    @DisplayName("Should display menu after welcome message")
    @Test
    void testDisplayMenu() {

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
        when(libraryInputDriver.getInput()).thenReturn("2").
                thenReturn("Harry Potter and the prisoner of azkaban").thenReturn("1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verify(libraryOutputDriver).print("Enter the title of the book you want to checkout: ");
        verify(libraryOutputDriver).print("Thank you! Enjoy the book");

        verifyBookListColumn();
        verify(libraryOutputDriver).print(book1);
        verify(libraryOutputDriver).print(book2);
        verify(libraryOutputDriver,never()).print(book3);

    }

    @DisplayName("Should display message if selected book is not available")
    @Test
    void testCheckoutForUnavailableBook() {
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

    @DisplayName("Should add book to the libraryMock after returning")
    @Test
    void testReturn() {
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

    @DisplayName("Should display a list of movies")
    @Test
    void testListMovies() {
        when(libraryInputDriver.getInput()).thenReturn("4").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyMovieListColumn();
        verify(libraryOutputDriver).print(movie1);
        verify(libraryOutputDriver).print(movie2);
        verify(libraryOutputDriver).print(movie3);
    }

    @DisplayName("Should checkout the movie up")
    @Test
    void testCheckoutMovie() {
        when(libraryInputDriver.getInput()).thenReturn("5").thenReturn("Up").thenReturn("4").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verify(libraryOutputDriver).print("Enter the title of the movie you want to checkout: ");

        verifyMovieListColumn();
        verify(libraryOutputDriver).print(movie2);
        verify(libraryOutputDriver).print(movie3);
        verify(libraryOutputDriver,never()).print(movie1);
    }

}
