package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.LibraryObject;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.common.Constants.*;

public class ReturnCommand implements Command {
    private LibraryObject libraryObject;

    ReturnCommand(LibraryObject libraryObject) {
        this.libraryObject = libraryObject;
    }

    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
        libraryOutputDriver.println(String.format(ENTER_THE_TITLE_YOU_WANT_TO_RETURN_MESSAGE, libraryObject.getType()));
        String libraryObjectToBeReturned = libraryInputDriver.getInput();
        if (!library.returnObject(libraryObject.withTitle(libraryObjectToBeReturned))) {
            libraryOutputDriver.println(String.format(TITLE_NOT_AVAILABLE_FOR_RETURN_MESSAGE, libraryObject.getType()));
            return;
        }
        libraryOutputDriver.println(String.format(SUCCESSFUL_RETURN_MESSAGE, libraryObject.getType()));
    }
}
