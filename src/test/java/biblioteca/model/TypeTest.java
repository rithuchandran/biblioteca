package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static biblioteca.model.Type.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeTest {
    private ArrayList<LibraryObject> availableList = new ArrayList<>();

    @BeforeEach
    void initialize() {
        availableList.add(new Book("Harry Potter and the philosopher's stone", "J K Rowling", 1997));
        availableList.add(new Book("Harry Potter and the chamber of secrets", "J K Rowling", 1998));
        availableList.add(new Book("Harry Potter and the prisoner of azkaban", "J K Rowling", 1999));
        availableList.add(new Movie("Up", "Peter Docter,Bob Peterson", 2009, 8.3));
        availableList.add(new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9));
        availableList.add(new Movie("Wreck-It Ralph", "Rick Moore", 2012, 7.8));
    }

    @DisplayName("Should return a list of available books")
    @Test
    void testGetTitleForBook() {
        String book1 = String.format("%-55s%-35s%-10s", "Harry Potter and the philosopher's stone", "J K Rowling", "1997");
        String book2 = String.format("%-55s%-35s%-10s", "Harry Potter and the chamber of secrets", "J K Rowling", "1998");
        String book3 = String.format("%-55s%-35s%-10s", "Harry Potter and the prisoner of azkaban", "J K Rowling", "1999");
        String result = book1 + "\n" + book2 + "\n" + book3 + "\n";
        assertEquals(result, BOOK.getTitle(availableList));
    }

    @DisplayName("Should return a list of available movies")
    @Test
    void testGetTitleForMovie() {
        String movie1 = String.format("%-55s%-35s%-10s%-10s", "Up", "Peter Docter,Bob Peterson", 2009, 8.3);
        String movie2 = String.format("%-55s%-35s%-10s%-10s", "Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9);
        String movie3 = String.format("%-55s%-35s%-10s%-10s", "Wreck-It Ralph", "Rick Moore", 2012, 7.8);
        String result = movie1 + "\n" + movie2 + "\n" + movie3 + "\n";
        assertEquals(result,MOVIE.getTitle(availableList));
    }

    @DisplayName("Should return movie for movie and book for book")
    @Test
    void testToString(){
        assertEquals("movie",MOVIE.toString());
        assertEquals("book",BOOK.toString());
    }
}
