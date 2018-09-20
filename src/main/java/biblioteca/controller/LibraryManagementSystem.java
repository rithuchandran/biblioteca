package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import java.util.HashMap;

import static biblioteca.common.Constants.*;

public class LibraryManagementSystem {

    private final OutputDriver libraryOutputDriver;
    private final InputDriver libraryInputDriver;
    private final Library library;

    public LibraryManagementSystem(OutputDriver outputDriver, InputDriver libraryInputDriver) {
        libraryOutputDriver = outputDriver;
        this.libraryInputDriver = libraryInputDriver;
        library = new Library();
    }

    public void start() {
        libraryOutputDriver.print(WELCOME_MESSAGE);
        HashMap<Integer,Menu> menuMap = new HashMap<>();
        menuMap.put(1,Menu.LIST_BOOKS);
        printMenu();
        int option = Integer.valueOf(libraryInputDriver.getInput());
        menuMap.get(option).doAction(libraryOutputDriver,library);
    }


    private void printMenu() {
        libraryOutputDriver.print(MENU_MESSAGE);
        libraryOutputDriver.print(MENU);
    }


}
