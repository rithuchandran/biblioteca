package biblioteca.controller;

import biblioteca.TestHelper;
import biblioteca.model.User;
import org.junit.jupiter.api.Test;

import static biblioteca.model.Book.aBook;
import static biblioteca.model.Movie.aMovie;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AuthorisedCommandTest extends TestHelper {

    @Test
    void testAuthorisedCommandForCheckoutWithoutLogin(){
        AuthorisedCommand command = new AuthorisedCommand(new CheckoutCommand(aBook()));
        command.doAction(libraryOutputDriver,libraryInputDriver,library,user);
        verify(libraryOutputDriver).println("Please login first!");
    }
    @Test
    void testAuthorisedCommandForCheckoutAfterLogin(){
        AuthorisedCommand command = new AuthorisedCommand(new CheckoutCommand(aBook()));
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1");
        Menu.LOGIN.doAction(libraryOutputDriver,libraryInputDriver,library);
        command.doAction(libraryOutputDriver,libraryInputDriver,library,new User("123-4567","password1"));
        verify(libraryOutputDriver).println("You are now logged in");
        verify(libraryOutputDriver).println("Enter the title of the book you want to checkout: ");

    }

    @Test
    void testAuthorisedCommandForReturnAfterLogin(){
        AuthorisedCommand command = new AuthorisedCommand(new ReturnCommand(aMovie()));
        when(libraryInputDriver.getInput()).thenReturn("123-4567").thenReturn("password1");
        Menu.LOGIN.doAction(libraryOutputDriver,libraryInputDriver,library);
        command.doAction(libraryOutputDriver,libraryInputDriver,library,new User("123-4567","password1"));
        verify(libraryOutputDriver).println("You are now logged in");
        verify(libraryOutputDriver).println("Enter the title of the movie you want to return: ");

    }
}
