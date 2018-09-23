package biblioteca;

import biblioteca.model.Book;
import biblioteca.model.LibraryObject;
import biblioteca.model.Movie;
import biblioteca.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LibraryInitializer {

    List<LibraryObject> getLibraryObjects() {
        List<LibraryObject> libraryObjects = new ArrayList<>();
        libraryObjects.add(new Movie("Up", "Peter Docter,Bob Peterson", 2009, 8.3));
        libraryObjects.add(new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9));
        libraryObjects.add(new Movie("Wreck-It Ralph", "Rick Moore", 2012, 7.8));
        libraryObjects.add(new Book("Harry Potter and the philosopher's stone", "J K Rowling", 1997));
        libraryObjects.add(new Book("Harry Potter and the chamber of secrets", "J K Rowling", 1998));
        libraryObjects.add(new Book("Harry Potter and the prisoner of azkaban", "J K Rowling", 1999));
        return libraryObjects;
    }

    Set<User> getUsers() {
        Set<User> Users = new HashSet<>();
        Users.add(new User("123-4567", "password1"));
        Users.add(new User("234-5678", "password2"));
        Users.add(new User("345-6789", "password3"));
        return Users;
    }
}
