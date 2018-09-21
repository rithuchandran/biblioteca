package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.common.Constants.COLUMNS;
import static biblioteca.common.Constants.LINE;

public enum Menu {
    LIST_BOOKS {
        @Override
        void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
            libraryOutputDriver.print(COLUMNS);
            libraryOutputDriver.print(LINE);
            String[] books = library.getBookTitles().split("\n");
            for (String book : books) {
                libraryOutputDriver.print(book);
            }
        }
    },
    CHECKOUT_ITEM {
        @Override
        void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
            libraryOutputDriver.print("Enter the title of the book you want to checkout: ");
            String bookToBeCheckedOut = libraryInputDriver.getInput();
            if(!library.checkout(bookToBeCheckedOut)){
                libraryOutputDriver.print("That book is not available");
                return;
            }
            libraryOutputDriver.print("Thank you! Enjoy the book");
        }
    },
    QUIT;

    void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
    }
}
