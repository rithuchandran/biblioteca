package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.Type;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.common.Constants.*;
import static biblioteca.model.Type.*;

public enum Menu {
    LIST_BOOKS {
        @Override
        void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
            listAction(libraryOutputDriver,library,BOOK,BOOK_COLUMNS);
        }
    },
    CHECKOUT_BOOK {
        @Override
        void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
            checkoutAction(libraryOutputDriver,libraryInputDriver,library,BOOK);
        }
    },
    RETURN_BOOK {
        @Override
        void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library){
            libraryOutputDriver.print("Enter the title of the book you want to return: ");
            String bookToBeReturned = libraryInputDriver.getInput();
            if(!library.returnBook(bookToBeReturned)){
                libraryOutputDriver.print("That is not a valid book to return");
                return;
            }
            libraryOutputDriver.print("Thank you for returning the book");
        }
    },
    LIST_MOVIES{
        @Override
        void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library) {
            listAction(libraryOutputDriver,library,MOVIE,MOVIE_COLUMNS);
        }
    },
    QUIT{
        @Override
         void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library){}
    };

    abstract void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library);
    private static void checkoutAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library, Type type){
        libraryOutputDriver.print(String.format("Enter the title of the %s you want to checkout: ",type));
        String bookToBeCheckedOut = libraryInputDriver.getInput();
        if(!library.checkout(bookToBeCheckedOut)){
            libraryOutputDriver.print(String.format("That %s is not available",type));
            return;
        }
        libraryOutputDriver.print(String.format("Thank you! Enjoy the %s",type));
    }
    private static void listAction(OutputDriver libraryOutputDriver, Library library,Type type,String column){
        libraryOutputDriver.print(column);
        libraryOutputDriver.print(LINE);
        String[] books = library.getTitles(type).split("\n");
        for (String book : books) {
            libraryOutputDriver.print(book);
        }
    }
}
