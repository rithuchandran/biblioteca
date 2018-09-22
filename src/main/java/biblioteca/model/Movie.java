package biblioteca.model;

import biblioteca.common.Constants;

import java.util.List;
import java.util.Objects;

public class Movie implements LibraryObject {
    private final String name;
    private final String director;
    private final int year;
    private final double rating;

    public Movie(String name, String director, int year, double rating) {

        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public static Movie aMovie() {
        return new Movie("", "", 0, 0);
    }

    @Override
    public String getTitle(final List<LibraryObject> availableList) {
        StringBuilder movieTitles = new StringBuilder();
        for (LibraryObject movie : availableList) {
            if (movie.getClass() == Movie.class) {
                movieTitles.append(movie).append("\n");
            }
        }
        return movieTitles.toString();
    }

    @Override
    public String getColumn() {
        return Constants.MOVIE_COLUMNS;
    }

    @Override
    public String getType() {
        return "movie";
    }

    @Override
    public LibraryObject withTitle(String title) {
        return new Movie(title,"",0,0);
    }

    @Override
    public String toString() {
        return String.format("%-55s%-35s%-10s%-10s", name, director, year, rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }


}
