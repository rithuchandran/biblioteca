package biblioteca.model;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.model.Book.aBook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(library.checkout(aBook().withTitle("Harry Potter and the prisoner of azkaban")));
    }

    @DisplayName("Should return the book list after checkout")
    @Test
    void testGetBookTitlesAfterCheckout() {
        Library library = new Library(libraryObjects, users);
        library.checkout(aBook().withTitle("Harry Potter and the prisoner of azkaban"));
        String result = String.format("%-55s%-35s%-10s\n", "Harry Potter and the philosopher's stone", "J K Rowling", "1997") +
                String.format("%-55s%-35s%-10s\n", "Harry Potter and the chamber of secrets", "J K Rowling", "1998");
        assertEquals(result, library.getTitles(aBook()));
    }

    @DisplayName("Should return the book list after returning")
    @Test
    void testReturn() {
        Library library = new Library(libraryObjects, users);
        library.checkout(aBook().withTitle("Harry Potter and the prisoner of azkaban"));
        library.returnObject(aBook().withTitle("Harry Potter and the prisoner of azkaban"));
        assertEquals(result, library.getTitles(aBook()));

    }

    @DisplayName("Should successfully login a valid user with valid password")
    @Test
    void testValidLogin(){
        Library library = new Library(libraryObjects, users);
        User user = new User("234-5678","password2");
        library.login(user);
        assertTrue(library.isLoggedIn(user));
    }

    @DisplayName("Should not allow invalid user to login")
    @Test
    void testInValidLogin(){
        Library library = new Library(libraryObjects, users);
        User user = new User("934-5678","password2");
        library.login(user);
        assertFalse(library.isLoggedIn(user));
    }

    @DisplayName("Should not allow a valid user with incorrect password to login")
    @Test
    void testInValidPasswordLogin(){
        Library library = new Library(libraryObjects, users);
        User user = new User("234-5678","password5");
        library.login(user);
        assertFalse(library.isLoggedIn(user));
    }

}
