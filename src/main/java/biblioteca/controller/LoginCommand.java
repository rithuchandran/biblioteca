package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.common.Constants.*;

public class LoginCommand implements Command {
    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
        libraryOutputDriver.print(ENTER_LIBRARY_NUMBER_MESSAGE);
        String libraryNumber = libraryInputDriver.getInput();
        libraryOutputDriver.print(ENTER_PASSWORD_MESSAGE);
        String password = libraryInputDriver.getInput();
        User currentUser = new User(libraryNumber, password);
        if (!library.authenticate(currentUser)) {
            libraryOutputDriver.println(UNSUCCESSFUL_LOGIN_MESSAGE);
            return;
        }
        libraryOutputDriver.println(SUCCESSFUL_LOGIN_MESSAGE);
    }
}
