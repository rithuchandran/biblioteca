package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList = new ArrayList<Book>();

    public Library() {
        bookList.add(new Book("Harry Potter and the philosopher's stone"));
        bookList.add(new Book("Harry Potter and the chamber of secrets"));
        bookList.add(new Book("Harry Potter and the prisoner of azkaban"));
    }

    public List<Book> getBooks(){
        return bookList;
    }

}
