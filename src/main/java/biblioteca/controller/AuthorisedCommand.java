package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.common.Constants.USER_NOT_LOGGED_IN_MESSAGE;

public class AuthorisedCommand implements Command {
    private Command command;

    AuthorisedCommand(Command command) {
        this.command = command;
    }

    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
        if (!library.isUserLoggedIn()){
            libraryOutputDriver.println(USER_NOT_LOGGED_IN_MESSAGE);
            return;
        }
        command.doAction(libraryOutputDriver,libraryInputDriver,library);
    }
}
