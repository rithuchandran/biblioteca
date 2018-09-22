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
    private final HashMap<Integer, Menu> menuMap;

    public LibraryManagementSystem(OutputDriver outputDriver, InputDriver libraryInputDriver) {
        libraryOutputDriver = outputDriver;
        this.libraryInputDriver = libraryInputDriver;
        library = new Library();
        menuMap = new HashMap<>();
        createMenuMap();
    }

    private void createMenuMap() {
        menuMap.put(0, Menu.QUIT);
        menuMap.put(1, Menu.LIST_BOOKS);
        menuMap.put(2, Menu.CHECKOUT_ITEM);
        menuMap.put(3, Menu.RETURN_ITEM);
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
            while (!menuMap.containsKey(option)) {
                libraryOutputDriver.print("Select a valid option!");
                option = Integer.valueOf(libraryInputDriver.getInput());
            }
            menuMap.get(option).doAction(libraryOutputDriver, libraryInputDriver, library);
        }
        while (menuMap.get(option) != Menu.QUIT);
    }

}
