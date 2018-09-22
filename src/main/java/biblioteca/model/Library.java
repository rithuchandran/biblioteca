package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<LibraryObject> checkedOutList;
    private List<LibraryObject> availableList;

    public Library() {
        availableList = new ArrayList<>();
        checkedOutList = new ArrayList<>();
        initializeBooks();
        initializeMovies();
    }

    private void initializeMovies() {
        availableList.add(new Movie("Up","Peter Docter,Bob Peterson",2009,8.3));
        availableList.add(new Movie("Big Hero 6", "Don Hall, Chris Williams", 2014, 7.9));
        availableList.add(new Movie("Wreck-It Ralph","Rick Moore",2012,7.8));
    }

    private void initializeBooks() {
        availableList.add(new Book("Harry Potter and the philosopher's stone", "J K Rowling", 1997));
        availableList.add(new Book("Harry Potter and the chamber of secrets", "J K Rowling", 1998));
        availableList.add(new Book("Harry Potter and the prisoner of azkaban", "J K Rowling", 1999));
    }

    public String getTitles(Type type) {
        return type.getTitle(availableList);
    }

    public boolean checkout(final String bookToBeCheckedOut) {
        if(!availableList.contains(new Book(bookToBeCheckedOut))){
            return false;
        }
        final int index = availableList.indexOf(new Book(bookToBeCheckedOut));
        checkedOutList.add(availableList.get(index));
        return availableList.remove(new Book(bookToBeCheckedOut));
    }

    boolean contains(final String bookTitle) {
        return availableList.contains(new Book(bookTitle));
    }

    public boolean returnBook(final String bookToBeReturned) {
        if(!checkedOutList.contains(new Book(bookToBeReturned))){
            return false;
        }
        final int index = checkedOutList.indexOf(new Book(bookToBeReturned));
        availableList.add(checkedOutList.get(index));
        checkedOutList.remove(checkedOutList.get(index));
        return true;
    }
}
