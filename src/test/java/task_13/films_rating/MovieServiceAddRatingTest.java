package task_13.films_rating;

import Task_13.accounting_for_student_grade.InvalidGradeException;
import Task_13.accounting_for_student_grade.StudentGrade;
import Task_13.films_rating.Movie;
import Task_13.films_rating.MovieService;
import Task_13.films_rating.Rating;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieServiceAddRatingTest extends MovieServiceTest {
    /**
     * Положительные кейсы
     * Валидная оценка от 1 до 10 для нового фильма: 3
     * Валидная оценка от 1 до 10 для существующего фильма: 5
     * Валидная оценка от 1 до 10 для фильма с пустым названием: 5
     * Валидная оценка с типом double: 5.0
     * Корнер кейсы
     * Валидная оценка: 1, 10
     * Негативные тесты
     * Невалидная оценка: -1, 11 -> IllegalArgumentException
     * Невалидная оценка для существующего фильма: -3 -> IllegalArgumentException
     * Невалидная оценка для несуществующего фильма: -9 -> IllegalArgumentException
     * Валидная оценка от 1 до 10 для фильма = null: - 5
     */

    //Проверка добавления оценки для нового фильма в пустой список
    @ParameterizedTest
    @ValueSource(doubles = {3, 5.5, 1, 10})
    public void userCanAddValidRatingForNewFilm(Number ratingValue) {
        Movie movie = new Movie("New", "Drama");
        Rating<Number> rating = new Rating<>(ratingValue);
        movieService.addRating(movie, rating);
        assertEquals(1, movieService.getFilmsRating().size());
        assertTrue(movieService.getFilmsRating().containsKey(movie));
        Rating<Number> actualRating = movieService.getFilmsRating().get(movie).getFirst();
        assertEquals(rating.getRating(), actualRating.getRating());
    }

    //Проверка добавления оценки для существующего фильма в непустой список
    @Test
    public void userCanAddValidRatingForExistsFilm() {
        Movie movie_1 = new Movie("New", "Drama");
        Movie movie_2 = new Movie("Another", "Comedy");
        movieService.addRating(movie_2, new Rating<>(10));
        movieService.addRating(movie_1, new Rating<>(9));
        movieService.addRating(movie_2, new Rating<>(5));
        movieService.addRating(movie_1, new Rating<>(5));
        assertEquals(2, movieService.getFilmsRating().size());
        assertTrue(movieService.getFilmsRating().containsKey(new Movie("New", "Drama")));
        assertTrue(movieService.getFilmsRating().containsKey(new Movie("Another", "Comedy")));
        List<Rating<Number>> actualRating = movieService.getFilmsRating().get(movie_1);
        assertEquals(2, actualRating.size());
        assertTrue(actualRating.contains(new Rating<Number>(9)));
        assertTrue(actualRating.contains(new Rating<Number>(5)));
    }

    //Проверка добавления невалидной оценки для нового фильма в пустой список
    @ParameterizedTest
    @ValueSource(doubles = {-1, 11, 0})
    public void userCannotAddInvalidRatingForFilm(Number ratingValue) {
        Movie movie = new Movie("New", "Drama");
        Rating<Number> rating = new Rating<>(ratingValue);
        assertThrows(IllegalArgumentException.class, () -> movieService.addRating(movie, rating),
                "При добавлении невалидного рейтинга не было выброшено исключение IllegalArgumentException");
        assertEquals(0, movieService.getFilmsRating().size());
    }

    //Проверка добавления невалидной оценки для существующего фильма
    @Test
    public void userCannotAddInvalidRatingForExistsFilm() {
        Movie movie = new Movie("New", "Drama");
        movieService.addRating(movie, new Rating<>(5));
        movieService.addRating(new Movie("Another", "Comedy"), new Rating<>(10));
        assertThrows(IllegalArgumentException.class, () -> movieService.addRating(movie, new Rating<>(100)),
                "При добавлении невалидного рейтинга не было выброшено исключение IllegalArgumentException");
        assertEquals(2, movieService.getFilmsRating().size());
        assertTrue(movieService.getFilmsRating().containsKey(new Movie("New", "Drama")));
        assertTrue(movieService.getFilmsRating().containsKey(new Movie("Another", "Comedy")));
        List<Rating<Number>> actualRating = movieService.getFilmsRating().get(movie);
        assertEquals(1, actualRating.size());
    }

    @Test
    public void userCanAddRatingsFromTwoThreads() throws IllegalArgumentException, InterruptedException {
        Movie movie_1 = new Movie("New", "Drama");
        Movie movie_2 = new Movie("Another", "Comedy");
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    movieService.addRating(movie_1, new Rating<>(i));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    movieService.addRating(movie_2, new Rating<>(i));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assertEquals(2, movieService.getFilmsRating().size());
        List<Rating<Number>> actualRatingFilm_1 = movieService.getFilmsRating().get(movie_1);
        assertEquals(10, actualRatingFilm_1.size());
        List<Rating<Number>> actualRatingFilm_2 = movieService.getFilmsRating().get(movie_2);
        assertEquals(10, actualRatingFilm_2.size());
    }
}
