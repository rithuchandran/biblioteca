import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    @DisplayName("should return perimeter as 6 for sides 1, 2, 3")
    @Test
    public void testPerimeter1() {
        int perimeter = new Triangle(1, 2, 3).perimeter();
        assertEquals(6, perimeter);
    }

    @DisplayName("should return perimeter as 7 for sides 2, 2, 3")
    @Test
    public void testPerimeter2() {
        int perimeter = new Triangle(2, 2, 3).perimeter();
        assertEquals(7, perimeter);
    }
}
