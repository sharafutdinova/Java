package Task_13.films_rating;

import java.util.*;
import java.util.stream.Collectors;

public class MovieService<T extends Number> {
    private Map<Movie, List<Rating>> filmsRating = new HashMap<>();

    public Map<Movie, List<Rating>> getFilmsRating() {
        return filmsRating;
    }

    public synchronized void addRating(Movie movie, Rating<T> rating) {
        Double ratingValue = rating.getRating().doubleValue();
        if (ratingValue >= 0 && ratingValue <= 10) {
            List<Rating> ratingForFilm;
            if (filmsRating.containsKey(movie)) {
                ratingForFilm = filmsRating.get(movie);
            } else {
                ratingForFilm = new ArrayList<>();
            }
            ratingForFilm.add(rating);
            filmsRating.put(movie, ratingForFilm);
        } else throw new IllegalArgumentException("Рейтинг может быть в диапазоне от 0 до 10.");
    }

    public Double getAverageRatingForFilm(Movie movie) {
        List<Rating> rating = filmsRating.get(movie);
        return rating.stream()
                .mapToDouble(r -> r.getRating().doubleValue())
                .average()
                .orElse(0.0);
    }

    public List<Movie> getSortedListByRating() {
        return filmsRating.entrySet().stream()
                .sorted((e1, e2) -> {
                    double avg1 = e1.getValue().stream().mapToDouble(r -> r.getRating().doubleValue()).average().orElse(0.0);
                    double avg2 = e2.getValue().stream().mapToDouble(r -> r.getRating().doubleValue()).average().orElse(0.0);
                    return Double.compare(avg2, avg1); // убывание
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
