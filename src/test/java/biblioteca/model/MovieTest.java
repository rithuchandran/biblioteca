package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MovieTest {
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
        Movie movie2 = null;
        assertNotEquals(movie2,movie1);
    }

    @DisplayName("Should expect null book to be unequal")
    @Test()
    void  testNotEqualsForDifferentClasses(){
        Book book1 = new Book("Head first java", "author", 0);
        Movie movie1 = new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9);
        assertNotEquals(movie1,book1);
    }
}
