package task_13.films_rating;

import Task_13.films_rating.Movie;
import Task_13.films_rating.Rating;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieServiceGetSortedListByRatingTest extends MovieServiceTest {
    /**
     * Сортировка для пустого списка
     * Сортировка для списка с 1 фильмом
     * Сортировка для списка с разными рейтингами
     * Сортировка для списка с одинаковыми рейтингами
     */

    //Сортировка списка с одним фильмом
    @Test
    public void userCanSortFilmsByRatingForListWithOneFilm() {
        Movie movie = new Movie("Action", "Drama");
        movieService.addRating(movie, new Rating<>(6));
        movieService.addRating(movie, new Rating<>(8));
        List<Movie> sortedFilms = movieService.getSortedListByRating();
        assertEquals(1, sortedFilms.size());
        assertEquals(movie, sortedFilms.getFirst());
    }

    //Сортировка фильмов с разными рейтингами
    @Test
    public void userCanSortFilmsByRatingForListWithSeveralFilms() {
        Movie movie_1 = new Movie("Action", "Drama");
        Movie movie_2 = new Movie("New", "Comedy");
        Movie movie_3 = new Movie("Test", "Drama");
        movieService.addRating(movie_1, new Rating<>(6));
        movieService.addRating(movie_1, new Rating<>(8.9));
        movieService.addRating(movie_2, new Rating<>(5.8));
        movieService.addRating(movie_3, new Rating<>(8));
        movieService.addRating(movie_3, new Rating<>(8.2));
        movieService.addRating(movie_3, new Rating<>(9.6));
        List<Movie> sortedFilms = movieService.getSortedListByRating();
        assertEquals(3, sortedFilms.size());
        assertEquals(movie_3, sortedFilms.getFirst());
        assertEquals(movie_2, sortedFilms.getLast());
    }

    //Сортировка фильмов с одинаковыми рейтингами
    @Test
    public void userCanSortFilmsByRatingForListWithSameRatings() {
        Movie movie_1 = new Movie("Action", "Drama");
        Movie movie_2 = new Movie("New", "Comedy");
        Movie movie_3 = new Movie("Test", "Drama");
        movieService.addRating(movie_1, new Rating<>(8));
        movieService.addRating(movie_1, new Rating<>(8.2));
        movieService.addRating(movie_1, new Rating<>(9.6));
        movieService.addRating(movie_2, new Rating<>(5.8));
        movieService.addRating(movie_3, new Rating<>(8));
        movieService.addRating(movie_3, new Rating<>(8.2));
        movieService.addRating(movie_3, new Rating<>(9.6));
        List<Movie> sortedFilms = movieService.getSortedListByRating();
        assertEquals(3, sortedFilms.size());
        assertEquals(movie_2, sortedFilms.getLast());
        assertTrue(sortedFilms.getFirst().equals(movie_1) || sortedFilms.getFirst().equals(movie_3));
    }

    @Test
    public void userCanSortFilmsByRatingForEmptyList() {
        List<Movie> sortedFilms = movieService.getSortedListByRating();
        assertEquals(0, sortedFilms.size());
    }
}
