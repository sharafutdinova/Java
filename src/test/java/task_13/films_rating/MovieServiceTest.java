package task_13.films_rating;

import Task_13.films_rating.Movie;
import Task_13.films_rating.MovieService;
import Task_13.films_rating.Rating;
import org.junit.jupiter.api.BeforeEach;
import practice_11.StringProcessor;

import java.util.List;

public class MovieServiceTest {
    protected MovieService<Number> movieService;

    @BeforeEach
    public void setupTest() {
        movieService = new MovieService<>();
    }

    public Double calculateAverageRatingForFilm(Movie movie) {
        List<Rating> rating = movieService.getFilmsRating().get(movie);
        return rating.stream()
                .mapToDouble(r -> r.getRating().doubleValue())
                .average()
                .orElse(0.0);
    }
}
