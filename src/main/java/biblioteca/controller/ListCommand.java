package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.LibraryObject;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.common.Constants.LINE;

public class ListCommand implements Command {
    private LibraryObject libraryObject;

    public ListCommand(LibraryObject libraryObject) {
        this.libraryObject = libraryObject;
    }

    @Override
    public void doAction(OutputDriver libraryOutputDriver, InputDriver libraryInputDriver, Library library, User user) {
        libraryOutputDriver.println(libraryObject.getColumn());
        libraryOutputDriver.println(LINE);
        String[] books = library.getTitles(libraryObject).split("\n");
        for (String book : books) {
            libraryOutputDriver.println(book);
        }
    }
}
