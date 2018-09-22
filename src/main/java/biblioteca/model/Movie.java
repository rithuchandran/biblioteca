package biblioteca.model;

import java.util.Objects;

public class Movie implements LibraryObject {
    private String name;
    private String director;
    private int year;
    private double rating;

    public Movie(String name, String director, int year, double rating) {

        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
    public Movie(String name){
        this(name,"0",0,0);
    }

    @Override
    public String toString() {
        return String.format("%-55s%-35s%-10s%-10s", name, director, year, rating) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }

}
