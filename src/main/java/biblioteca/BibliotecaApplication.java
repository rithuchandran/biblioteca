package biblioteca;

import biblioteca.controller.LibraryManagementSystem;
import biblioteca.model.LibraryObject;
import biblioteca.model.User;
import biblioteca.view.LibraryInputDriver;
import biblioteca.view.LibraryOutputDriver;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApplication {

    public static void main(String[] args) {
        LibraryInitializer libraryInitializer = new LibraryInitializer();
        List<LibraryObject> libraryObjects = new ArrayList<>(libraryInitializer.getLibraryObjects());
        List<User> users = new ArrayList<>(libraryInitializer.getUsers());
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(new LibraryOutputDriver(), new LibraryInputDriver(),libraryObjects,users);
        libraryManagementSystem.start();
    }
}
