package biblioteca.common;

public class Constants {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca!";
    public static final String BOOK_COLUMNS = String.format("%-55s%-35s%-10s", "Title", "Author", "Year Published");
    public static final String MOVIE_COLUMNS = String.format("%-55s%-35s%-10s%-10s", "Title", "Director", "Year", "Rating");
    public static final String LINE = "------------------------------------------------------------------------------------------------------------- ";
    public static final String MENU_MESSAGE = "Select an option :";
    public static final String MENU = "Press 1 to display list of books\n" +
            "Press 2 to checkout a book\n" + "Press 3 to return a book\n" + "Press 4 to display list of movies\n" + "Press 0 to quit!\n";
}
