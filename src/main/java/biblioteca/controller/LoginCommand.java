package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class LoginCommand implements Command {
    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
        libraryOutputDriver.print("Enter library number: ");
        String libraryNumber = libraryInputDriver.getInput();
        libraryOutputDriver.print("Enter password: ");
        String password = libraryInputDriver.getInput();
        User currentUser = new User(libraryNumber, password);
        if (!library.authenticate(currentUser)) {
            libraryOutputDriver.println("Login unsuccessful! Incorrect library number/ password");
            return;
        }
        libraryOutputDriver.println("You are now logged in");
    }
}
