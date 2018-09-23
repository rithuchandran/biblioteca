package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    void testnotEqual(){
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
}
