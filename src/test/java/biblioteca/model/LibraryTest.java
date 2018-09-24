package biblioteca.model;

import biblioteca.TestHelper;
import biblioteca.controller.Command;
import biblioteca.controller.LoginCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.model.Book.aBook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class LibraryTest extends TestHelper {

    private String result = String.format("%-55s%-35s%-10s\n", "Harry Potter and the philosopher's stone", "J K Rowling", "1997") +
            String.format("%-55s%-35s%-10s\n", "Harry Potter and the chamber of secrets", "J K Rowling", "1998") +
            String.format("%-55s%-35s%-10s\n", "Harry Potter and the prisoner of azkaban", "J K Rowling", "1999");

    @DisplayName("Should return the list of existing books")
    @Test
    void testGetBookTitles() {
        Library library = new Library(libraryObjects, users);
        assertEquals(result, library.getTitles(aBook()));
    }

    @DisplayName("Should remove Harry Potter and the prisoner of azkaban")
    @Test
    void testCheckout() {
        Library library = new Library(libraryObjects, users);
        Command commandLogin = new LoginCommand();
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1");

        commandLogin.doAction(libraryOutputDriver,libraryInputDriver,library);
        assertTrue(library.checkout(aBook().withTitle("Harry Potter and the prisoner of azkaban")));
    }

    @DisplayName("Should return the book list after checkout")
    @Test
    void testGetBookTitlesAfterCheckout() {
        Library library = new Library(libraryObjects, users);
        Command commandLogin = new LoginCommand();
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1");

        commandLogin.doAction(libraryOutputDriver,libraryInputDriver,library);
        library.checkout(aBook().withTitle("Harry Potter and the prisoner of azkaban"));

        String result = String.format("%-55s%-35s%-10s\n", "Harry Potter and the philosopher's stone", "J K Rowling", "1997") +
                String.format("%-55s%-35s%-10s\n", "Harry Potter and the chamber of secrets", "J K Rowling", "1998");
        assertEquals(result, library.getTitles(aBook()));
    }

    @DisplayName("Should return the book list after returning")
    @Test
    void testReturn() {
        Library library = new Library(libraryObjects, users);
        Command commandLogin = new LoginCommand();
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1");

        commandLogin.doAction(libraryOutputDriver,libraryInputDriver,library);
        library.checkout(aBook().withTitle("Harry Potter and the prisoner of azkaban"));
        library.returnObject(aBook().withTitle("Harry Potter and the prisoner of azkaban"));

        assertEquals(result, library.getTitles(aBook()));

    }

    @DisplayName("Should successfully authenticate a valid user with valid password")
    @Test
    void testValidLogin(){
        Library library = new Library(libraryObjects, users);

        User user = new User("234-5678","password2");
        library.authenticate(user);

        assertTrue(library.isUserLoggedIn());
    }

    @DisplayName("Should not allow invalid user to authenticate")
    @Test
    void testInValidLogin(){
        Library library = new Library(libraryObjects, users);
        User user = new User("934-5678","password2");

        library.authenticate(user);

        assertFalse(library.isUserLoggedIn());
    }

    @DisplayName("Should not allow a valid user with incorrect password to authenticate")
    @Test
    void testInValidPasswordLogin(){
        Library library = new Library(libraryObjects, users);
        User user = new User("234-5678","password5");

        library.authenticate(user);

        assertFalse(library.isUserLoggedIn());
    }

}
