package biblioteca.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Library {

    private List<LibraryObject> checkedOutList;
    private List<LibraryObject> availableList;
    private Set<User> userSet;
    private Set<User> loggedInUserSet;


    public Library(List<LibraryObject> libraryObjects, Set<User> users) {
        availableList = new ArrayList<>(libraryObjects);
        this.userSet = users;
        checkedOutList = new ArrayList<>();
        loggedInUserSet = new HashSet<>();
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
        return availableList.remove(libraryObject);
    }

    public boolean returnObject(final LibraryObject libraryObject) {
        if (!checkedOutList.contains(libraryObject)) {
            return false;
        }
        final int index = checkedOutList.indexOf(libraryObject);
        availableList.add(checkedOutList.get(index));
        checkedOutList.remove(checkedOutList.get(index));
        return true;
    }

    public boolean login(final User user) {
        if (!userSet.contains(user)) {
            return false;
        }
        if (!user.isRightPassword(userSet)) {
            return false;
        }
        loggedInUserSet.add(user);
        return true;
    }

    public boolean isLoggedIn(final User user) {
        return loggedInUserSet.contains(user);
    }

    public String getInformation(final User user) {
        ArrayList<User> users = new ArrayList<>(userSet);
        return users.get(users.indexOf(user)).toString();
    }
}
