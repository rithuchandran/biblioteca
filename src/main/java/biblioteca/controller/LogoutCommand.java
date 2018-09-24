package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.common.Constants.LOGOUT_MESSAGE;

public class LogoutCommand implements Command {
    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
        library.logOutUser();
        libraryOutputDriver.println(LOGOUT_MESSAGE);
    }
}
