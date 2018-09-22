package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static biblioteca.model.Movie.aMovie;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MovieTest {
    private ArrayList<LibraryObject> availableList = new ArrayList<>();

    @BeforeEach
    void initialize() {
        availableList.add(new Movie("Up", "Peter Docter,Bob Peterson", 2009, 8.3));
        availableList.add(new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9));
        availableList.add(new Movie("Wreck-It Ralph", "Rick Moore", 2012, 7.8));
    }

    @DisplayName("Should return title, director, year& rating of the movie")
    @Test
    void testToStringOfMovie(){
        Movie movie = new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9);
        assertEquals(String.format("%-55s%-35s%-10s%-10s","Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9),movie.toString());
    }

    @DisplayName("Should expect two movies with same title to be equal")
    @Test()
    void  testEquals(){
        Movie movie1 = new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9);
        Movie movie2 = new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9);
        assertEquals(movie1,movie2);
    }

    @DisplayName("Should expect null book to be unequal")
    @Test()
    void  testNotEqualsForNullValue(){
        Movie movie1 = new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9);
        assertNotEquals(null,movie1);
    }

    @DisplayName("Should expect null book to be unequal")
    @Test()
    void  testNotEqualsForDifferentClasses(){
        Book book1 = new Book("Head first java", "author", 0);
        Movie movie1 = new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9);
        assertNotEquals(movie1,book1);
    }

    @DisplayName("Should return a list of available movies")
    @Test
    void testGetTitleForMovie() {
        String movie1 = String.format("%-55s%-35s%-10s%-10s", "Up", "Peter Docter,Bob Peterson", 2009, 8.3);
        String movie2 = String.format("%-55s%-35s%-10s%-10s", "Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9);
        String movie3 = String.format("%-55s%-35s%-10s%-10s", "Wreck-It Ralph", "Rick Moore", 2012, 7.8);
        String result = movie1 + "\n" + movie2 + "\n" + movie3 + "\n";
        assertEquals(result,aMovie().getTitle(availableList));
    }
}
