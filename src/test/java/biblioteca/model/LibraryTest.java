package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {
    @DisplayName("Should return the list of existing books")
    @Test
    void testGetBookTitles() {
        Library library = new Library();
        String result = "Harry Potter and the philosopher's stone,author,0\n" +
                "Harry Potter and the chamber of secrets,author,0\n" +
                "Harry Potter and the prisoner of azkaban,author,0\n";
        assertEquals(result, library.getBookTitles());
    }
}
