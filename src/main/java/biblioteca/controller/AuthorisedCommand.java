package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class AuthorisedCommand implements Command {
    private Command command;

    AuthorisedCommand(Command command) {
        this.command = command;
    }

    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
        if (!library.isUserLoggedIn()){
            libraryOutputDriver.println("Please login first!");
            return;
        }
        command.doAction(libraryOutputDriver,libraryInputDriver,library);
    }
}
