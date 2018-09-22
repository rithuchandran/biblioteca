package biblioteca.controller;

import biblioteca.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnCommandTest extends TestHelper {
    @DisplayName("Should call returnObject when user wants to checkout a book ")
    @Test
    void testDoActionForReturn() {
        when(libraryInputDriver.getInput()).thenReturn("Harry Potter and the philosopher's stone");

        Menu.RETURN_BOOK.doAction(libraryOutputDriver, libraryInputDriver, libraryMock);

        verify(libraryMock).returnObject("Harry Potter and the philosopher's stone");
    }
}
