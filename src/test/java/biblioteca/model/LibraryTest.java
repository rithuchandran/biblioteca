package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {
    String result = String.format("%-55s%-35s%-10s\n", "Harry Potter and the philosopher's stone", "J K Rowling", "1997") +
            String.format("%-55s%-35s%-10s\n", "Harry Potter and the chamber of secrets", "J K Rowling", "1998") +
            String.format("%-55s%-35s%-10s\n", "Harry Potter and the prisoner of azkaban", "J K Rowling", "1999");

    @DisplayName("Should return the list of existing books")
    @Test
    void testGetBookTitles() {
        Library library = new Library();
        assertEquals(result, library.getTitles(Type.BOOK));
    }

    @DisplayName("Should return true for Harry Potter and the philosopher's stone")
    @Test
    void testContains() {
        Library library = new Library();
        assertTrue(library.contains("Harry Potter and the philosopher's stone"));
    }

    @DisplayName("Should remove Harry Potter and the prisoner of azkaban")
    @Test
    void testCheckout() {
        Library library = new Library();
        assertTrue(library.contains("Harry Potter and the prisoner of azkaban"));
        library.checkout("Harry Potter and the prisoner of azkaban");
        assertFalse(library.contains("Harry Potter and the prisoner of azkaban"));
    }

    @DisplayName("Should return the book list after checkout")
    @Test
    void testGetBookTitlesAfterCheckout() {
        Library library = new Library();
        library.checkout("Harry Potter and the prisoner of azkaban");
        String result = String.format("%-55s%-35s%-10s\n", "Harry Potter and the philosopher's stone", "J K Rowling", "1997") +
                String.format("%-55s%-35s%-10s\n", "Harry Potter and the chamber of secrets", "J K Rowling", "1998");
        assertEquals(result, library.getTitles(Type.BOOK));
    }

    @DisplayName("Should return the book list after checkout")
    @Test
    void testReturn() {
        Library library = new Library();
        library.checkout("Harry Potter and the prisoner of azkaban");
        assertFalse(library.contains("Harry Potter and the prisoner of azkaban"));
        library.returnBook("Harry Potter and the prisoner of azkaban");
        assertEquals(result, library.getTitles(Type.BOOK));

    }
}
