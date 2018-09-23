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
        libraryManagementSystem = new LibraryManagementSystem(libraryOutputDriver, libraryInputDriver, libraryObjects, users);
    }

    private void verifyWelcomeAndMenu() {
        verify(libraryOutputDriver).println("Welcome to Biblioteca!");
        verify(libraryOutputDriver).println("Select an option :");
        verify(libraryOutputDriver).println("Press 1 to display list of books\n" +
                "Press 2 to checkout a book\n" +
                "Press 3 to return a book\n" +
                "Press 4 to display list of movies\n" +
                "Press 5 to checkout a movie\n" +
                "Press 6 to return a movie\n" +
                "Press 7 to login\n" +
                "Press 8 to display user information\n" +
                "Press 0 to quit!\n");
    }

    private void verifyBookListColumn() {
        verify(libraryOutputDriver).println(String.format("%-55s%-35s%-10s", "Title", "Author", "Year Published"));
        verify(libraryOutputDriver).println("------------------------------------------------------------------------------------------------------------- ");
    }

    private void verifyMovieListColumn() {
        verify(libraryOutputDriver).println(String.format("%-55s%-35s%-10s%-10s", "Title", "Director", "Year", "Rating"));
        verify(libraryOutputDriver).println("------------------------------------------------------------------------------------------------------------- ");
    }

    private void verifyLogin() {
        verify(libraryOutputDriver).print("Enter library number: ");
        verify(libraryOutputDriver).print("Enter password: ");
    }

    @DisplayName("Should display a welcome message upon starting the application")
    @Test
    void testDisplayWelcomeMessage() {
        when(libraryInputDriver.getInput()).thenReturn("0");
        libraryManagementSystem.start();
        verify(libraryOutputDriver).println("Welcome to Biblioteca!");
    }

    @DisplayName("Should display menu after welcome message")
    @Test
    void testDisplayMenu() {

        when(libraryInputDriver.getInput()).thenReturn("1").thenReturn("0");
        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyBookListColumn();
        verify(libraryOutputDriver).println(book1);
        verify(libraryOutputDriver).println(book2);
        verify(libraryOutputDriver).println(book3);
    }

    @DisplayName("Should show error message for wrong option")
    @Test
    void testWrongOption() {
        when(libraryInputDriver.getInput()).thenReturn("15").thenReturn("1").thenReturn("0");
        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyBookListColumn();
        verify(libraryOutputDriver).println(book1);
        verify(libraryOutputDriver).println(book2);
        verify(libraryOutputDriver).println(book3);
    }

    @DisplayName("Should show updated list after checking out Harry Potter and the prisoner of azkaban")
    @Test
    void testCheckout() {
        when(libraryInputDriver.getInput()).thenReturn("7").thenReturn("123-4567").thenReturn("password1").thenReturn("2").
                thenReturn("Harry Potter and the prisoner of azkaban").thenReturn("1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyLogin();
        verify(libraryOutputDriver).println("Enter the title of the book you want to checkout: ");
        verify(libraryOutputDriver).println("Thank you! Enjoy the book");

        verifyBookListColumn();
        verify(libraryOutputDriver).println(book1);
        verify(libraryOutputDriver).println(book2);
        verify(libraryOutputDriver, never()).println(book3);

    }

    @DisplayName("Should display message if selected book is not available")
    @Test
    void testCheckoutForUnavailableBook() {
        when(libraryInputDriver.getInput()).thenReturn("7").thenReturn("123-4567").thenReturn("password1").thenReturn("2").
                thenReturn("Head first java").thenReturn("1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyLogin();
        verify(libraryOutputDriver).println("Enter the title of the book you want to checkout: ");
        verify(libraryOutputDriver).println("That book is not available");

        verifyBookListColumn();
        verify(libraryOutputDriver).println(book1);
        verify(libraryOutputDriver).println(book2);
        verify(libraryOutputDriver).println(book3);
    }

    @DisplayName("Should add book to the libraryMock after returning")
    @Test
    void testReturn() {
        when(libraryInputDriver.getInput()).thenReturn("7").thenReturn("123-4567").thenReturn("password1").thenReturn("2").
                thenReturn("Harry Potter and the prisoner of azkaban").thenReturn("3").
                thenReturn("Harry Potter and the prisoner of azkaban").thenReturn("1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyLogin();
        verify(libraryOutputDriver).println("Enter the title of the book you want to checkout: ");
        verify(libraryOutputDriver).println("Thank you! Enjoy the book");
        verify(libraryOutputDriver).println("Enter the title of the book you want to return: ");
        verifyBookListColumn();
        verify(libraryOutputDriver).println(book1);
        verify(libraryOutputDriver).println(book2);
        verify(libraryOutputDriver).println(book3);
    }

    @DisplayName("Should display success message after returning")
    @Test
    void testSuccessfulReturn() {
        when(libraryInputDriver.getInput()).thenReturn("7").thenReturn("123-4567").thenReturn("password1").thenReturn("2").
                thenReturn("Harry Potter and the prisoner of azkaban").thenReturn("3").
                thenReturn("Harry Potter and the prisoner of azkaban").thenReturn("1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyLogin();
        verify(libraryOutputDriver).println("Enter the title of the book you want to checkout: ");
        verify(libraryOutputDriver).println("Thank you! Enjoy the book");

        verify(libraryOutputDriver).println("Enter the title of the book you want to return: ");
        verify(libraryOutputDriver).println("Thank you for returning the book");
        verifyBookListColumn();
        verify(libraryOutputDriver).println(book1);
        verify(libraryOutputDriver).println(book2);
        verify(libraryOutputDriver).println(book3);
    }

    @DisplayName("Should display success message after returning")
    @Test
    void testUnsuccessfulReturn() {
        when(libraryInputDriver.getInput()).thenReturn("7").thenReturn("123-4567").thenReturn("password1").thenReturn("3").
                thenReturn("Harry Potter").thenReturn("1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyLogin();
        verify(libraryOutputDriver).println("Enter the title of the book you want to return: ");
        verify(libraryOutputDriver).println("That is not a valid book to return");
        verifyBookListColumn();
        verify(libraryOutputDriver).println(book1);
        verify(libraryOutputDriver).println(book2);
        verify(libraryOutputDriver).println(book3);

    }

    @DisplayName("Should display a list of movies")
    @Test
    void testListMovies() {
        when(libraryInputDriver.getInput()).thenReturn("4").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyMovieListColumn();
        verify(libraryOutputDriver).println(movie1);
        verify(libraryOutputDriver).println(movie2);
        verify(libraryOutputDriver).println(movie3);
    }

    @DisplayName("Should checkout the movie up")
    @Test
    void testCheckoutMovie() {
        when(libraryInputDriver.getInput()).thenReturn("7").thenReturn("123-4567").thenReturn("password1").
                thenReturn("5").thenReturn("Up").thenReturn("4").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyLogin();
        verify(libraryOutputDriver).println("Enter the title of the movie you want to checkout: ");

        verifyMovieListColumn();
        verify(libraryOutputDriver).println(movie2);
        verify(libraryOutputDriver).println(movie3);
        verify(libraryOutputDriver, never()).println(movie1);
    }

    @DisplayName("Should allow registered user with valid credentials to login")
    @Test
    void testValidUserLogin() {
        when(libraryInputDriver.getInput()).thenReturn("7").thenReturn("123-4567").thenReturn("password1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu();
        verifyLogin();
    }

}
