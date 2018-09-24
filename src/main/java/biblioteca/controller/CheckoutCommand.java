package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.LibraryObject;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.common.Constants.*;

class CheckoutCommand implements Command {
    private LibraryObject libraryObject;

    CheckoutCommand(LibraryObject libraryObject) {
        this.libraryObject = libraryObject;
    }

    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
        libraryOutputDriver.println(String.format(ENTER_THE_TITLE_YOU_WANT_TO_CHECKOUT_MESSAGE, libraryObject.getType()));
        String itemToBeCheckedOut = libraryInputDriver.getInput();
        if (!library.checkout(libraryObject.withTitle(itemToBeCheckedOut))) {
            libraryOutputDriver.println(String.format(TITLE_NOT_AVAILABLE_FOR_CHECKOUT_MESSAGE, libraryObject.getType()));
            return;
        }
        libraryOutputDriver.println(String.format(SUCCESSFUL_CHECKOUT_MESSAGE, libraryObject.getType()));

    }
}
