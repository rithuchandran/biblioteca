package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

import static biblioteca.model.Book.aBook;

public class Library {

    private List<LibraryObject> checkedOutList;
    private List<LibraryObject> availableList;

    public Library(List<LibraryObject> libraryObjects) {
        availableList = new ArrayList<>(libraryObjects);
        checkedOutList = new ArrayList<>();
    }

    public String getTitles(LibraryObject libraryObject) {
        return libraryObject.getTitle(availableList);
    }

    public boolean checkout(LibraryObject libraryObject) {
        if(!availableList.contains(libraryObject)){
            return false;
        }
        final int index = availableList.indexOf(libraryObject);
        checkedOutList.add(availableList.get(index));
        return availableList.remove(libraryObject);
    }

    public boolean returnObject(final String bookToBeReturned) {
        if(!checkedOutList.contains(aBook().withTitle(bookToBeReturned))){
            return false;
        }
        final int index = checkedOutList.indexOf(aBook().withTitle(bookToBeReturned));
        availableList.add(checkedOutList.get(index));
        checkedOutList.remove(checkedOutList.get(index));
        return true;
    }
}
