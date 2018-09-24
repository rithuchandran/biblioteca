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

    private void verifyWelcomeAndMenu(int n) {
        verify(libraryOutputDriver).println("Welcome to Biblioteca!");
        verify(libraryOutputDriver, times(n)).println("Select an option :");
        verify(libraryOutputDriver, times(n)).println("");
        verify(libraryOutputDriver, times(n)).println("Press 1 to display list of books\n" +
                "Press 2 to checkout a book\n" +
                "Press 3 to return a book\n" +
                "Press 4 to display list of movies\n" +
                "Press 5 to checkout a movie\n" +
                "Press 6 to return a movie\n" +
                "Press 7 to login\n" +
                "Press 8 to display user information\n" +
                "Press 9 to logout\n" +
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

        verifyWelcomeAndMenu(2);
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

        verifyWelcomeAndMenu(3);
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

        verifyWelcomeAndMenu(4);
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

        verifyWelcomeAndMenu(4);
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

        verifyWelcomeAndMenu(5);
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

        verifyWelcomeAndMenu(5);
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

        verifyWelcomeAndMenu(4);
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

        verifyWelcomeAndMenu(2);
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

        verifyWelcomeAndMenu(4);
        verifyLogin();
        verify(libraryOutputDriver).println("Enter the title of the movie you want to checkout: ");

        verifyMovieListColumn();
        verify(libraryOutputDriver).println(movie2);
        verify(libraryOutputDriver).println(movie3);
        verify(libraryOutputDriver, never()).println(movie1);
    }

    @DisplayName("Should allow registered user with valid credentials to authenticate")
    @Test
    void testValidUserLogin() {
        when(libraryInputDriver.getInput()).thenReturn("7").thenReturn("123-4567").thenReturn("password1").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu(2);
        verifyLogin();
    }

    @DisplayName("Should display user information if the user is logged in")
    @Test
    void testUserInformation() {
        when(libraryInputDriver.getInput()).thenReturn("7").thenReturn("123-4567").thenReturn("password1").thenReturn("8").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu(3);
        verifyLogin();
        verify(libraryOutputDriver).println("Name: user1\nEmail address: user1@mail.com\nPhone number: 1234567891");
    }

    @DisplayName("Should logout user1 and let user2 to login")
    @Test
    void testLogoutAndLogin(){
        when(libraryInputDriver.getInput()).thenReturn("7").thenReturn("123-4567").thenReturn("password1").thenReturn("9").
                thenReturn("7").thenReturn("234-5678").thenReturn("password2").thenReturn("8").thenReturn("0");

        libraryManagementSystem.start();

        verifyWelcomeAndMenu(5);
        verify(libraryOutputDriver,times(2)).print("Enter library number: ");
        verify(libraryOutputDriver,times(2)).print("Enter password: ");

        verify(libraryOutputDriver).println("You are now logged out");
        verify(libraryOutputDriver).println("Name: user2\nEmail address: user2@mail.com\nPhone number: 1234567892");

    }
}
