package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {
    @DisplayName("Should return the list of existing books")
    @Test
    void testGetBookTitles() {
        Library library = new Library();
        String result = String.format("%-53s%-30s%-8s\n", "Harry Potter and the philosopher's stone", "J K Rowling", "1997") +
                String.format("%-53s%-30s%-8s\n", "Harry Potter and the chamber of secrets", "J K Rowling", "1998") +
                String.format("%-53s%-30s%-8s\n", "Harry Potter and the prisoner of azkaban", "J K Rowling", "1999");
        assertEquals(result, library.getBookTitles());
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
        String result = String.format("%-53s%-30s%-8s\n", "Harry Potter and the philosopher's stone", "J K Rowling", "1997") +
                String.format("%-53s%-30s%-8s\n", "Harry Potter and the chamber of secrets", "J K Rowling", "1998");
        assertEquals(result, library.getBookTitles());
    }

    @DisplayName("Should return the book list after checkout")
    @Test
    void testReturn() {
        Library library = new Library();
        library.checkout("Harry Potter and the prisoner of azkaban");
        assertFalse(library.contains("Harry Potter and the prisoner of azkaban"));
        library.returnBook("Harry Potter and the prisoner of azkaban");
        String result2 = String.format("%-53s%-30s%-8s\n", "Harry Potter and the philosopher's stone", "J K Rowling", "1997") +
                String.format("%-53s%-30s%-8s\n", "Harry Potter and the chamber of secrets", "J K Rowling", "1998") +
                String.format("%-53s%-30s%-8s\n", "Harry Potter and the prisoner of azkaban", "J K Rowling", "1999");
        assertEquals(result2, library.getBookTitles());

    }
}
