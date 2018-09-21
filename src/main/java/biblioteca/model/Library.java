package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> checkedOutBookList ;
    private List<Book> availableBookList;

    public Library() {
        availableBookList = new ArrayList<>();
        checkedOutBookList = new ArrayList<>();
        availableBookList.add(new Book("Harry Potter and the philosopher's stone", "J K Rowling", 1997));
        availableBookList.add(new Book("Harry Potter and the chamber of secrets", "J K Rowling", 1998));
        availableBookList.add(new Book("Harry Potter and the prisoner of azkaban", "J K Rowling", 1999));
    }

    public String getBookTitles() {
        StringBuilder bookTitles = new StringBuilder();
        for (Book book : availableBookList) {
            bookTitles.append(book).append("\n");
        }
        return bookTitles.toString();
    }

    public boolean checkout(final String bookToBeCheckedOut) {
        final int index = availableBookList.indexOf(new Book(bookToBeCheckedOut));
        checkedOutBookList.add(availableBookList.get(index));
        return availableBookList.remove(new Book(bookToBeCheckedOut));
    }

    boolean contains(final String bookTitle) {
        return availableBookList.contains(new Book(bookTitle));
    }

    public boolean returnBook(final String bookToBeReturned) {
        if(!checkedOutBookList.contains(new Book(bookToBeReturned))){
            return false;
        }
        final int index = checkedOutBookList.indexOf(new Book(bookToBeReturned));
        availableBookList.add(checkedOutBookList.get(index));
        checkedOutBookList.remove(checkedOutBookList.get(index));
        return true;
    }
}
