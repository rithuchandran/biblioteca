package biblioteca.common;

public class Constants {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca!";
    public static final String BOOK_COLUMNS = String.format("%-55s%-35s%-10s", "Title", "Author", "Year Published");
    public static final String MOVIE_COLUMNS = String.format("%-55s%-35s%-10s%-10s", "Title", "Director", "Year", "Rating");
    public static final String LINE = "----------------------------------------------------------------" +
            "--------------------------------------------- ";
    public static final String MENU_MESSAGE = "Select an option :";
    public static final String MENU = "Press 1 to display list of books\n" +
            "Press 2 to checkout a book\n" +
            "Press 3 to return a book\n" +
            "Press 4 to display list of movies\n" +
            "Press 5 to checkout a movie\n" +
            "Press 6 to return a movie\n" +
            "Press 7 to login\n" +
            "Press 8 to display user information\n" +
            "Press 9 to logout\n" +
            "Press 0 to quit!\n";
    public static final String INVALID_OPTION_MESSAGE = "Select a valid option!";
    public static final String USER_NOT_LOGGED_IN_MESSAGE = "Please login first!";

    public static final String ENTER_THE_TITLE_YOU_WANT_TO_CHECKOUT_MESSAGE = "Enter the title of the %s you want to checkout: ";
    public static final String TITLE_NOT_AVAILABLE_FOR_CHECKOUT_MESSAGE = "That %s is not available";
    public static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the %s";

    public static final String ENTER_THE_TITLE_YOU_WANT_TO_RETURN_MESSAGE = "Enter the title of the %s you want to return: ";
    public static final String TITLE_NOT_AVAILABLE_FOR_RETURN_MESSAGE = "That is not a valid %s to return";
    public static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the %s";

    public static final String USER_ALREADY_LOGGED_IN_MESSAGE = "User is already logged in";
    public static final String ENTER_LIBRARY_NUMBER_MESSAGE = "Enter library number: ";
    public static final String ENTER_PASSWORD_MESSAGE = "Enter password: ";
    public static final String UNSUCCESSFUL_LOGIN_MESSAGE = "Login unsuccessful! Incorrect library number/ password";
    public static final String SUCCESSFUL_LOGIN_MESSAGE = "You are now logged in";

    public static final String LOGOUT_MESSAGE = "You are now logged out";
}
