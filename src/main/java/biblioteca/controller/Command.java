package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public interface Command {
    void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library);
}
