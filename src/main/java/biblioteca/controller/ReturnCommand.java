package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.LibraryObject;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class ReturnCommand implements Command {
    private LibraryObject libraryObject;

    ReturnCommand(LibraryObject libraryObject) {
        this.libraryObject = libraryObject;
    }

    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
        libraryOutputDriver.println(String.format("Enter the title of the %s you want to return: ", libraryObject.getType()));
        String libraryObjectToBeReturned = libraryInputDriver.getInput();
        if (!library.returnObject(libraryObject.withTitle(libraryObjectToBeReturned))) {
            libraryOutputDriver.println(String.format("That is not a valid %s to return", libraryObject.getType()));
            return;
        }
        libraryOutputDriver.println(String.format("Thank you for returning the %s", libraryObject.getType()));
    }
}
