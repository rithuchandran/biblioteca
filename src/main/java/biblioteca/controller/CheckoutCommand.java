package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.LibraryObject;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class CheckoutCommand implements Command {
    private LibraryObject libraryObject;

    public CheckoutCommand(LibraryObject libraryObject) {
        this.libraryObject = libraryObject;
    }

    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
        libraryOutputDriver.print(String.format("Enter the title of the %s you want to checkout: ",libraryObject.getType()));
        String itemToBeCheckedOut = libraryInputDriver.getInput();
        if(!library.checkout(libraryObject.withTitle(itemToBeCheckedOut))){
            libraryOutputDriver.print(String.format("That %s is not available",libraryObject.getType()));
            return;
        }
        libraryOutputDriver.print(String.format("Thank you! Enjoy the %s",libraryObject.getType()));
    }
}
