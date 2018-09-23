package biblioteca.model;

import biblioteca.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static biblioteca.model.Book.aBook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest extends TestHelper {

    private ArrayList<LibraryObject> availableList = new ArrayList<>();

    @BeforeEach
    void initialise() {
        availableList.add(new Book("Harry Potter and the philosopher's stone", "J K Rowling", 1997));
        availableList.add(new Book("Harry Potter and the chamber of secrets", "J K Rowling", 1998));
        availableList.add(new Book("Harry Potter and the prisoner of azkaban", "J K Rowling", 1999));
    }

    @DisplayName("Should return title of the book")
    @Test
    void testToStringOfBook(){
        Book book = new Book("Head first java", "author", 0);
        assertEquals(String.format("%-55s%-35s%-10s","Head first java", "author", "0"),book.toString());
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
        assertNotEquals(book1,null);
    }

    @DisplayName("Should expect null book to be unequal")
    @Test()
    void  testNotEqualsForDifferentClasses(){
        Book book1 = new Book("Head first java", "author", 0);
        assertNotEquals(book1,new Library(new ArrayList<>(), users));
    }

    @DisplayName("Should return a list of available books")
    @Test
    void testGetTitleForBook() {
        String book1 = String.format("%-55s%-35s%-10s", "Harry Potter and the philosopher's stone", "J K Rowling", "1997");
        String book2 = String.format("%-55s%-35s%-10s", "Harry Potter and the chamber of secrets", "J K Rowling", "1998");
        String book3 = String.format("%-55s%-35s%-10s", "Harry Potter and the prisoner of azkaban", "J K Rowling", "1999");
        String result = book1 + "\n" + book2 + "\n" + book3 + "\n";
        assertEquals(result, aBook().getTitle(availableList));
    }

}
