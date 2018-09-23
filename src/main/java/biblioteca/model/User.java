package biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class User {
    private final String libraryNumber;
    private final String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(libraryNumber, user.libraryNumber);
    }

    boolean isRightPassword(final Set<User> users) {
        final List<User> userList = new ArrayList<>(users);
        int index = userList.indexOf(this);
        return password.equals(userList.get(index).password);
    }
}
