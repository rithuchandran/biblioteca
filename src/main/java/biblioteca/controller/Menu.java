package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.model.Book.aBook;
import static biblioteca.model.Movie.aMovie;


public enum Menu {
    QUIT(new QuitCommand()),
    LIST_BOOKS (new ListCommand(aBook())),
    CHECKOUT_BOOK (new AuthorisedCommand(new CheckoutCommand(aBook()))),
    RETURN_BOOK (new AuthorisedCommand(new ReturnCommand(aBook()))),
    LIST_MOVIES(new ListCommand(aMovie())),
    CHECKOUT_MOVIE(new AuthorisedCommand(new CheckoutCommand(aMovie()))),
    RETURN_MOVIE(new AuthorisedCommand(new ReturnCommand(aMovie()))),
    LOGIN(new LoginCommand()),
    DISPLAY_INFORMATION(new AuthorisedCommand(new DisplayInformationCommand()));

    private Command command;
    Menu(Command command){
        this.command = command;
    }
    void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library){
        this.command.doAction(libraryOutputDriver,libraryInputDriver,library);
    }
}



