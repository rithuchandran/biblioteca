package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.OutputDriver;

import static biblioteca.common.Constants.COLUMNS;
import static biblioteca.common.Constants.LINE;

public enum Menu {
    LIST_BOOKS{
        @Override
        void doAction(OutputDriver libraryOutputDriver, Library library) {
            libraryOutputDriver.print(COLUMNS);
            libraryOutputDriver.print(LINE);
            String[] books = library.getBookTitles().split("\n");
            for (String book : books) {
                String[] token = book.split(",");
                libraryOutputDriver.print(token[0] + "\t\t\t\t\t" + token[1] + "\t\t\t\t\t\t" + token[2]);
            }
        }
    };
     void doAction(OutputDriver libraryOutputDriver, Library library){}
}
