package biblioteca.model;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.model.Book.aBook;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest extends TestHelper {

    String result = String.format("%-55s%-35s%-10s\n", "Harry Potter and the philosopher's stone", "J K Rowling", "1997") +
            String.format("%-55s%-35s%-10s\n", "Harry Potter and the chamber of secrets", "J K Rowling", "1998") +
            String.format("%-55s%-35s%-10s\n", "Harry Potter and the prisoner of azkaban", "J K Rowling", "1999");

    @DisplayName("Should return the list of existing books")
    @Test
    void testGetBookTitles() {
        Library library = new Library(libraryObjects);
        assertEquals(result, library.getTitles(aBook()));
    }

    @DisplayName("Should remove Harry Potter and the prisoner of azkaban")
    @Test
    void testCheckout() {
        Library library = new Library(libraryObjects);
        assertTrue(library.checkout(aBook().withTitle("Harry Potter and the prisoner of azkaban")));
    }

    @DisplayName("Should return the book list after checkout")
    @Test
    void testGetBookTitlesAfterCheckout() {
        Library library = new Library(libraryObjects);
        library.checkout(aBook().withTitle("Harry Potter and the prisoner of azkaban"));
        String result = String.format("%-55s%-35s%-10s\n", "Harry Potter and the philosopher's stone", "J K Rowling", "1997") +
                String.format("%-55s%-35s%-10s\n", "Harry Potter and the chamber of secrets", "J K Rowling", "1998");
        assertEquals(result, library.getTitles(aBook()));
    }

    @DisplayName("Should return the book list after returning")
    @Test
    void testReturn() {
        Library library = new Library(libraryObjects);
        library.checkout(aBook().withTitle("Harry Potter and the prisoner of azkaban"));
        library.returnObject("Harry Potter and the prisoner of azkaban");
        assertEquals(result, library.getTitles(aBook()));

    }
}
