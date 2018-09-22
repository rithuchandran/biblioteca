package biblioteca.model;

import java.util.List;

public enum Type {
    BOOK{
        @Override
        String getTitle(List<LibraryObject> availableList){
            StringBuilder bookTitles = new StringBuilder();
            for ( LibraryObject aBook:availableList) {
                if (aBook.getClass() == Book.class){
                    bookTitles.append(aBook).append("\n");
                }
            }
            return bookTitles.toString();
        }

        @Override
        public String toString() {
            return "book";
        }
    },
    MOVIE{
        @Override
        String getTitle(List<LibraryObject> availableList){
            StringBuilder movieTitles = new StringBuilder();
            for ( LibraryObject movie:availableList) {
                if (movie.getClass() == Movie.class){
                    movieTitles.append(movie).append("\n");
                }
            }
            return movieTitles.toString();

        }

        @Override
        public String toString() {
            return "movie";
        }
    };

    abstract String getTitle(List<LibraryObject> availableList);
}
