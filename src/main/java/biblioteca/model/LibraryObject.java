package biblioteca.model;

import java.util.List;

public interface LibraryObject {
    String getTitle(List<LibraryObject> availableList);
    String getColumn();
    String getType();
    LibraryObject withTitle(String title);
}
