package task_13.films_rating;

import Task_13.films_rating.Movie;
import Task_13.films_rating.Rating;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovieServiceGetAverageRatingForFilmTest extends MovieServiceTest {
    /**
     * Проверки для метода вычисления среднего рейтинга фильма
     * Положительные
     * Вычисление для 1 значения в списке из нескольких фильмов
     * Вычисление для нескольких разных значений для одного фильма
     * Вычисление для null
     * Негативные
     * Вычисление для несуществуего фильма -> NullPointerException
     * Вычисление в пустом списке -> NullPointerException
     */
    @Test
    public void userCanGetAverageRatingForFilmWithOneGrade() {
        Movie movie = new Movie("Action", "Drama");
        Rating<Number> rating = new Rating<>(10);
        movieService.addRating(new Movie("Another", "Comedy"), new Rating<>(6));
        movieService.addRating(new Movie("New", "Comedy"), new Rating<>(8));
        movieService.addRating(movie, rating);
        Double actualAverageValue = movieService.getAverageRatingForFilm(movie);
        assertEquals(rating.getRating().doubleValue(), actualAverageValue);
    }

    @Test
    public void userCanGetAverageRatingForFilmWithSeveralGrades() {
        Movie movie = new Movie("Action", "Drama");
        movieService.addRating(new Movie("Another", "Comedy"), new Rating<>(6));
        movieService.addRating(movie, new Rating<>(8));
        movieService.addRating(movie, new Rating<>(5.8));
        movieService.addRating(movie, new Rating<>(10));
        Double expectedAverageValue = calculateAverageRatingForFilm(movie);
        Double actualAverageValue = movieService.getAverageRatingForFilm(movie);
        assertEquals(expectedAverageValue, actualAverageValue);
    }

    @Test
    public void userCannotGetAverageRatingForNotExistsFilm() {
        Movie movie = new Movie("Action", "Drama");
        movieService.addRating(new Movie("Another", "Comedy"), new Rating<>(6));
        movieService.addRating(new Movie("New", "Comedy"), new Rating<>(8));
        assertThrows(NullPointerException.class, () -> movieService.getAverageRatingForFilm(movie),
                "При вычислении рейтинга для фильма, которого нет в списке, не выбрасывается исключение NullPointerException");
    }

    @Test
    public void userCannotGetAverageRatingForEmptyList() {
        Movie movie = new Movie("Action", "Drama");
        assertThrows(NullPointerException.class, () -> movieService.getAverageRatingForFilm(movie),
                "При вычислении рейтинга для фильма, в пустом списке, не выбрасывается исключение NullPointerException");
    }

    @Test
    public void userCannotGetAverageRatingForNullFilm() {
        Movie movie = null;
        assertThrows(NullPointerException.class, () -> movieService.getAverageRatingForFilm(movie),
                "При вычислении рейтинга для null фильма не выбрасывается исключение NullPointerException");
    }
}
