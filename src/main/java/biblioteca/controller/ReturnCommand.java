package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.LibraryObject;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class ReturnCommand implements Command{
    private LibraryObject libraryObject;

    public ReturnCommand(LibraryObject libraryObject) {
        this.libraryObject = libraryObject;
    }

    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
        libraryOutputDriver.print("Enter the title of the book you want to return: ");
        String bookToBeReturned = libraryInputDriver.getInput();
        if(!library.returnObject(bookToBeReturned)){
            libraryOutputDriver.print("That is not a valid book to return");
            return;
        }
        libraryOutputDriver.print("Thank you for returning the book");
    }
}
