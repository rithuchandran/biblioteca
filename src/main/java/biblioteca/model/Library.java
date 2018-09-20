package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList = new ArrayList<Book>();

    public Library() {
        bookList.add(new Book("Harry Potter and the philosopher's stone", "J K Rowling", 1997));
        bookList.add(new Book("Harry Potter and the chamber of secrets", "J K Rowling", 1998));
        bookList.add(new Book("Harry Potter and the prisoner of azkaban", "J K Rowling", 1999));
    }

    public String getBookTitles() {
        StringBuilder bookTitles = new StringBuilder();
        for (Book book : bookList) {
            bookTitles.append(book).append("\n");
        }
        return bookTitles.toString();
    }

}
