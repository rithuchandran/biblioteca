package biblioteca.view;

public class LibraryOutputDriver implements OutputDriver {

    @Override
    public void println(String string) {
        System.out.println(string);
    }

    @Override
    public void print(String string) {
        System.out.print(string);
    }
}
