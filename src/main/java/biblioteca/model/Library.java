package biblioteca.model;

import java.util.*;

public class Library {

    private List<LibraryObject> checkedOutList;
    private List<LibraryObject> availableList;
    private List<User> userList;
    private User currentUser;

    public Library(List<LibraryObject> libraryObjects, List<User> users) {
        availableList = new ArrayList<>(libraryObjects);
        this.userList = users;
        checkedOutList = new ArrayList<>();
    }

    public String getTitles(final LibraryObject libraryObject) {
        return libraryObject.getTitle(availableList);
    }

    public boolean checkout(final LibraryObject libraryObject) {
        if (!availableList.contains(libraryObject)) {
            return false;
        }
        final int index = availableList.indexOf(libraryObject);
        checkedOutList.add(availableList.get(index));
        currentUser.checkOut(libraryObject);
        return availableList.remove(libraryObject);
    }

    public boolean returnObject(final LibraryObject libraryObject) {
        if (!(checkedOutList.contains(libraryObject) && currentUser.contains(libraryObject))) {
            return false;
        }
        final int index = checkedOutList.indexOf(libraryObject);
        availableList.add(checkedOutList.get(index));
        checkedOutList.remove(checkedOutList.get(index));
        currentUser.returnObject(libraryObject);
        return true;
    }

    public boolean authenticate(final User user) {
        if (!userList.contains(user)) {
            return false;
        }
        if (!user.isRightPassword(userList)) {
            return false;
        }
        currentUser = userList.get(userList.indexOf(user));
        return true;
    }

    public boolean isUserLoggedIn() {
        return currentUser != null;
    }

    public String getInformation() {
        return currentUser.toString();
    }

    public void logOutUser() {
        currentUser = null;
    }
}
