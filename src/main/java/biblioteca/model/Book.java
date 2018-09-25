package biblioteca.model;

import biblioteca.common.Constants;

import java.util.List;
import java.util.Objects;

public class Book implements LibraryObject {
    private final String title;
    private final String author;
    private final int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public static Book aBook() {
        return new Book("", "", 0);
    }

    @Override
    public LibraryObject withTitle(String title) {
        return new Book(title, "", 0);
    }

    @Override
    public String getTitle(List<LibraryObject> availableList) {
        StringBuilder bookTitles = new StringBuilder();
        for (LibraryObject aBook : availableList) {
            if (aBook.getClass() == Book.class) {
                bookTitles.append(aBook).append("\n");
            }
        }
        return bookTitles.toString();
    }

    @Override
    public String getColumn() {
        return Constants.BOOK_COLUMNS;
    }

    @Override
    public String getType() {
        return "book";
    }

    @Override
    public String toString() {
        return String.format("%-55s%-35s%-10s", title, author, yearOfPublication);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title.toLowerCase(), book.title.toLowerCase());
    }


}
