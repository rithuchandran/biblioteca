package biblioteca.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryInputDriverTest {
    @Test
    void testMenuInput() {
        setSystemIn("3\n");

        LibraryInputDriver inputDriver = new LibraryInputDriver();
        assertEquals("3", inputDriver.getInput());
    }

    private void setSystemIn(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @AfterEach
    void setup() {
        System.setIn(System.in);
    }
}
