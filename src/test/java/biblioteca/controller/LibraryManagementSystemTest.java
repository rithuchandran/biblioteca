package biblioteca.controller;

import biblioteca.model.Book;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class LibraryManagementSystemTest {
    private OutputDriver LibraryOutputDriver;
    private List<Book> bookList;

    @BeforeEach
    void initialize() {
        LibraryOutputDriver = mock(OutputDriver.class);
        bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter and the philosopher's stone"));
        bookList.add(new Book("Harry Potter and the chamber of secrets"));
        bookList.add(new Book("Harry Potter and the prisoner of azkaban"));
    }


    @DisplayName("Should display a welcome message upon starting the application")
    @Test
    void testDisplayWelcomeMessage() {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(LibraryOutputDriver);
        libraryManagementSystem.start();
        verify(LibraryOutputDriver).print("Welcome to Biblioteca!");
    }

    @DisplayName("Should display a list of books after displaying welcome message")
    @Test
    void testDisplayBookList() {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(LibraryOutputDriver);
        libraryManagementSystem.start();
        verify(LibraryOutputDriver).print("Welcome to Biblioteca!");
        verify(LibraryOutputDriver).print(bookList.toString());
    }

}
