package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {
    @DisplayName("Should return title of the book")
    @Test
    void testToStringOfBook(){
        Book book = new Book("Head first java", "author", 0);
        assertEquals(String.format("%-53s%-30s%-8s","Head first java", "author", "0"),book.toString());
    }

    @DisplayName("Should expect two books with same title to be equal")
    @Test()
    void  testEquals(){
        Book book1 = new Book("Head first java", "author", 0);
        Book book2 = new Book("Head first java", "author", 0);
        assertEquals(book1,book2);
    }

    @DisplayName("Should expect null book to be unequal")
    @Test()
    void  testNotEqualsForNullValue(){
        Book book1 = new Book("Head first java", "author", 0);
        Book book2 = null;
        assertNotEquals(book1,book2);
    }

    @DisplayName("Should expect null book to be unequal")
    @Test()
    void  testNotEqualsForDifferentClasses(){
        Book book1 = new Book("Head first java", "author", 0);
        assertNotEquals(book1,new Library());
    }

}
