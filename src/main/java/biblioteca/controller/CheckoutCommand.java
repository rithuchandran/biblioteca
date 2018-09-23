package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.LibraryObject;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class CheckoutCommand implements Command {
    private LibraryObject libraryObject;

    public CheckoutCommand(LibraryObject libraryObject) {
        this.libraryObject = libraryObject;
    }

    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library, User user) {
        libraryOutputDriver.println(String.format("Enter the title of the %s you want to checkout: ",libraryObject.getType()));
        String itemToBeCheckedOut = libraryInputDriver.getInput();
        if(!library.checkout(libraryObject.withTitle(itemToBeCheckedOut))){
            libraryOutputDriver.println(String.format("That %s is not available",libraryObject.getType()));
            return;
        }
        libraryOutputDriver.println(String.format("Thank you! Enjoy the %s",libraryObject.getType()));
    }
}
