package biblioteca.view;

import java.util.Scanner;

public class LibraryInputDriver implements InputDriver {
    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
