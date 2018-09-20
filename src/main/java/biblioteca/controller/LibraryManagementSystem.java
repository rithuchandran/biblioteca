package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.common.Constants.*;

public class LibraryManagementSystem {

    private final OutputDriver LibraryOutputDriver;
    private final InputDriver LibraryInputDriver;
    private final Library library;

    public LibraryManagementSystem(OutputDriver outputDriver, InputDriver libraryInputDriver) {
        LibraryOutputDriver = outputDriver;
        LibraryInputDriver = libraryInputDriver;
        library = new Library();
    }

    public void start() {
        LibraryOutputDriver.print(WELCOME_MESSAGE);
        printMenu();
        int option = Integer.valueOf(LibraryInputDriver.getInput());
        if (option == 1) {
            printTitles();
        }
    }

    private void printMenu() {
        LibraryOutputDriver.print(MENU_MESSAGE);
        LibraryOutputDriver.print(MENU);
    }

    private void printTitles() {
        LibraryOutputDriver.print(COLUMNS);
        LibraryOutputDriver.print(LINE);
        String[] books = library.getBookTitles().split("\n");
        for (String book : books) {
            String[] token = book.split(",");
            LibraryOutputDriver.print(token[0] + "\t\t\t\t\t" + token[1] + "\t\t\t\t\t\t" + token[2]);
        }
    }
}
