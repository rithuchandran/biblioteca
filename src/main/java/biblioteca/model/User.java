package biblioteca.model;

import java.util.*;

public class User {
    private final String libraryNumber;
    private String password;
    private String name;
    private String email;
    private long phoneNumber;
    private List<LibraryObject> checkedOutList = new ArrayList<>();

    public User(String libraryNumber, String password, String name, String email, long phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(String libraryNumber, String password) {
        this(libraryNumber, password, "default_name", "default_mail", 0);
    }

    void checkOut(LibraryObject libraryObject){
        checkedOutList.add(libraryObject);
    }

    void returnObject(LibraryObject libraryObject){
        checkedOutList.remove(libraryObject);
    }

    boolean isRightPassword(final Collection<User> users) {
        final List<User> userList = new ArrayList<>(users);
        int index = userList.indexOf(this);
        return password.equals(userList.get(index).password);
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

    @Override
    public String toString() {
        return String.format("Name: %s\nEmail address: %s\nPhone number: %s", name, email, phoneNumber);
    }



}
