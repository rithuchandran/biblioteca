package biblioteca;

import biblioteca.model.Book;
import biblioteca.model.LibraryObject;
import biblioteca.model.Movie;
import biblioteca.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LibraryInitializer {

    List<LibraryObject> getLibraryObjects() {
        List<LibraryObject> libraryObjects = new ArrayList<>();
        libraryObjects.add(new Movie("Up", "Peter Docter,Bob Peterson", 2009, 8.3));
        libraryObjects.add(new Movie("Lilo and Stitch", "Chris Sanders, Dean DeBlois", 2002, 7.2));
        libraryObjects.add(new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9));
        libraryObjects.add(new Movie("Wreck-It Ralph", "Rick Moore", 2012, 7.8));
        libraryObjects.add(new Book("Harry Potter and the philosopher's stone", "J K Rowling", 1997));
        libraryObjects.add(new Book("Harry Potter and the chamber of secrets", "J K Rowling", 1998));
        libraryObjects.add(new Book("Harry Potter and the prisoner of azkaban", "J K Rowling", 1999));
        return libraryObjects;
    }

    List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("123-4567", "password1", "user1", "user1@mail.com", 1234567891));
        users.add(new User("234-5678", "password2",  "user2", "user2@mail.com", 1234567892));
        users.add(new User("345-6789", "password3",  "user3", "user3@mail.com", 1234567893));
        return users;
    }
}
