package Task_13.films_rating;

import java.util.Objects;

public class Movie {
    private String name;
    private String genre;

    public Movie(String name, String genre) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Название не может быть null или пустым");
        if (genre == null || genre.isEmpty())
            throw new IllegalArgumentException("Жанр не может быть null или пустым");
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) && Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre);
    }
}
