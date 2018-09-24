package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class DisplayInformationCommand implements Command {
    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
        libraryOutputDriver.println(library.getInformation());
    }
}
