package biblioteca.model;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @DisplayName("should expect two users with same library number and password to be equal")
    @Test
    void testEqual(){
        User user1 = new User("123-1234","abc");
        User user2 = new User("123-1234","abc");

        assertEquals(user1,user2);
    }

    @DisplayName("should expect two users with same library number to be equal")
    @Test
    void testEqual2(){
        User user1 = new User("123-1234","abc");
        User user2 = new User("123-1234","abcd");

        assertEquals(user1,user2);
    }

    @DisplayName("should expect two users with different library number to be unequal")
    @Test
    void testNotEqual(){
        User user1 = new User("123-1234","abc");
        User user2 = new User("987-1234","abc");

        assertNotEquals(user1,user2);
    }

    @DisplayName("should expect null user to be not equal")
    @Test
    void testNull(){
        User user1 = new User("123-1234","abc");

        assertNotEquals(user1,null);
    }

    @DisplayName("should return true for correct password")
    @Test
    void testCorrectPassword(){
        List<User> userList = new ArrayList<>();
        User user1 = new User("123-1234","abc");
        userList.add(user1);

        assertTrue(user1.isRightPassword(userList));
    }

    @DisplayName("should return user information containing name, email & phone number")
    @Test
    void testToString(){
        User user1 = new User("123-1234","abc","userA","emailid@blah.com",1111111111);

        String result = "Name: userA\nEmail address: emailid@blah.com\nPhone number: 1111111111";
        assertEquals(result,user1.toString());
    }

    @DisplayName("should add the book/movie to the user after checkout")
    @Test
    void testCheckout(){
        User user1 = new User("123-1234","abc");
        LibraryObject movie = Movie.aMovie().withTitle("Up");

        user1.checkOut(movie);

        assertTrue(user1.contains(movie));
    }

    @DisplayName("should remove the book/movie from the user after returning")
    @Test
    void testReturn(){
        User user1 = new User("123-1234","abc");
        LibraryObject movie = Movie.aMovie().withTitle("Up");

        user1.checkOut(movie);
        assertTrue(user1.contains(movie));

        user1.returnObject(movie);
        assertFalse(user1.contains(movie));
    }

}
