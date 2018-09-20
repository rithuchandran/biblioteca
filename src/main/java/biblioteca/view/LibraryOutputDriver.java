package biblioteca.view;

public class LibraryOutputDriver implements OutputDriver {

    @Override
    public void print(String object) {
        System.out.println(object);
    }
}
