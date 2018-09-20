package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {
    @DisplayName("Should return the list of existing books")
    @Test
    void testGetBooks(){
        Library library = new Library();
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter and the philosopher's stone"));
        books.add(new Book("Harry Potter and the chamber of secrets"));
        books.add(new Book("Harry Potter and the prisoner of azkaban"));
        assertEquals(books,library.getBooks());
    }
}
