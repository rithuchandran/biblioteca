package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList = new ArrayList<>();
    private List<Book> availableBookList;

    public Library() {
        bookList.add(new Book("Harry Potter and the philosopher's stone", "J K Rowling", 1997));
        bookList.add(new Book("Harry Potter and the chamber of secrets", "J K Rowling", 1998));
        bookList.add(new Book("Harry Potter and the prisoner of azkaban", "J K Rowling", 1999));
        availableBookList = new ArrayList<>(bookList);
    }

    public String getBookTitles() {
        StringBuilder bookTitles = new StringBuilder();
        for (Book book : availableBookList) {
            bookTitles.append(book).append("\n");
        }
        return bookTitles.toString();
    }

    public boolean checkout(String bookToBeCheckedOut) {
        return availableBookList.remove(new Book(bookToBeCheckedOut));
    }

    boolean contains(String bookTitle) {
        return availableBookList.contains(new Book(bookTitle));
    }

    public boolean returnBook(String bookToBeReturned) {
        if(!bookList.contains(new Book(bookToBeReturned))){
            return false;
        }
        int index = bookList.indexOf(new Book(bookToBeReturned));
        availableBookList.add(bookList.get(index));
        return true;
    }
}
