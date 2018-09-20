package biblioteca.controller;

import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.view.OutputDriver;

import java.util.List;

import static biblioteca.common.Constants.*;

public class LibraryManagementSystem {

    private final OutputDriver LibraryOutputDriver;
    private final Library library;

    public LibraryManagementSystem(OutputDriver outputDriver) {
        LibraryOutputDriver = outputDriver;
        library = new Library();
    }

    public void start() {
        LibraryOutputDriver.print(WELCOME_MESSAGE);
        List<Book> books = library.getBooks();
        StringBuilder bookTitles = new StringBuilder();
        for(Book book:books){
            bookTitles.append(book).append("\n");
        }
        LibraryOutputDriver.print(bookTitles.toString());
    }
}
