package biblioteca;

import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.LibraryInputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.mock;

public class TestHelper {
    protected OutputDriver libraryOutputDriver;
    protected InputDriver libraryInputDriver;
    protected Library libraryMock;
    protected Library library;
    protected List<LibraryObject> libraryObjects;
    protected String book1 = "";
    protected String book2 = "";
    protected String book3 = "";

    protected String movie1 = "";
    protected String movie2 = "";
    protected String movie3 = "";
    protected Set<User> users = new HashSet<>();
    protected User user;


    @BeforeEach
    protected void initialize() {
        libraryOutputDriver = mock(OutputDriver.class);
        libraryInputDriver = mock(LibraryInputDriver.class);
        libraryMock = mock(Library.class);
        libraryObjects = new ArrayList<>();
        user = new User("123-4567", "password1", "user1", "user1@mail.com", 1234567891);
        users.add(user);
        users.add(new User("234-5678", "password2",  "user2", "user2@mail.com", 1234567892));
        users.add(new User("345-6789", "password3",  "user3", "user3@mail.com", 1234567893));

        libraryObjects.add(new Movie("Up","Peter Docter,Bob Peterson",2009,8.3));
        libraryObjects.add(new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9));
        libraryObjects.add(new Movie("Wreck-It Ralph","Rick Moore",2012,7.8));

        libraryObjects.add(new Book("Harry Potter and the philosopher's stone", "J K Rowling", 1997));
        libraryObjects.add(new Book("Harry Potter and the chamber of secrets", "J K Rowling", 1998));
        libraryObjects.add(new Book("Harry Potter and the prisoner of azkaban", "J K Rowling", 1999));
        library = new Library(libraryObjects, users);

        book1 = String.format("%-55s%-35s%-10s", "Harry Potter and the philosopher's stone", "J K Rowling", "1997");
        book2 = String.format("%-55s%-35s%-10s", "Harry Potter and the chamber of secrets", "J K Rowling", "1998");
        book3 = String.format("%-55s%-35s%-10s", "Harry Potter and the prisoner of azkaban", "J K Rowling", "1999");

        movie1 = String.format("%-55s%-35s%-10s%-10s", "Up", "Peter Docter,Bob Peterson", 2009, 8.3);
        movie2 = String.format("%-55s%-35s%-10s%-10s", "Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9);
        movie3 = String.format("%-55s%-35s%-10s%-10s", "Wreck-It Ralph", "Rick Moore", 2012, 7.8);
    }
}
