package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.LibraryObject;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import java.util.List;

import static biblioteca.common.Constants.*;

public class LibraryManagementSystem {

    private final OutputDriver libraryOutputDriver;
    private final InputDriver libraryInputDriver;
    private final Library library;

    public LibraryManagementSystem(OutputDriver outputDriver, InputDriver libraryInputDriver, List<LibraryObject> libraryObjects) {
        libraryOutputDriver = outputDriver;
        this.libraryInputDriver = libraryInputDriver;
        library = new Library(libraryObjects);
    }

    public void start() {
        libraryOutputDriver.print(WELCOME_MESSAGE);
        printMenu();
        doMenuAction();
    }

    private void printMenu() {
        libraryOutputDriver.print(MENU_MESSAGE);
        libraryOutputDriver.print(MENU);
    }

    private void doMenuAction() {
        int option;
        do {
            option = Integer.valueOf(libraryInputDriver.getInput());
            while (option<0 || option > 5){
                libraryOutputDriver.print("Select a valid option!");
                option = Integer.valueOf(libraryInputDriver.getInput());
            }
            Menu.values()[option].doAction(libraryOutputDriver, libraryInputDriver, library);
        }
        while (Menu.values()[option] != Menu.QUIT);
    }

}
