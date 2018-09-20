package biblioteca;

import biblioteca.controller.LibraryManagementSystem;
import biblioteca.view.LibraryOutputDriver;

public class BibliotecaApplication {

    public static void main(String[] args) {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(new LibraryOutputDriver());
        libraryManagementSystem.start();
    }
}
