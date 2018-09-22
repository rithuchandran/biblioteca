package biblioteca;

import biblioteca.controller.LibraryManagementSystem;
import biblioteca.model.Book;
import biblioteca.model.LibraryObject;
import biblioteca.model.Movie;
import biblioteca.view.LibraryInputDriver;
import biblioteca.view.LibraryOutputDriver;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApplication {

    public static void main(String[] args) {
        List<LibraryObject> libraryObjects = new ArrayList<>();
        libraryObjects.add(new Movie("Up","Peter Docter,Bob Peterson",2009,8.3));
        libraryObjects.add(new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9));
        libraryObjects.add(new Movie("Wreck-It Ralph","Rick Moore",2012,7.8));
        libraryObjects.add(new Book("Harry Potter and the philosopher's stone", "J K Rowling", 1997));
        libraryObjects.add(new Book("Harry Potter and the chamber of secrets", "J K Rowling", 1998));
        libraryObjects.add(new Book("Harry Potter and the prisoner of azkaban", "J K Rowling", 1999));
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(new LibraryOutputDriver(), new LibraryInputDriver(),libraryObjects);
        libraryManagementSystem.start();
    }
}
