package tp.movies;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MovieFactory {
    List<Movie> movies = Arrays.asList(
            new Movie("Harry Potter à l'École des Sorciers", 2001, "Chris Columbus",
                    "le début du destion magique d'un garçon pas comme les autres"),
            new Movie("Harry Potter et la Chambre des Secrets", 2002, "Chris Columbus",
                    "Dans les entrailles de Poudlard, le mal se réveille"),
            new Movie("Harry Potter et le Prisonnier d'Azkaban", 2004, "Alfonso Cuarón",
                    "Les secrets du passé jaillissent. Tout ce qui à été imaginé sera transformé"),
            new Movie("Harry Potter et la Coupe de Feu", 2005, "Mike Newell",
                    "Des heures sombres et difficiles s'annoncent"),
            new Movie("Harry Potter et l'Ordre du Phénix", 2007, "David Yates",
                    "La rébellion commence à Poudlard"),
            new Movie("Harry Potter et le Prince de Sang-Mêlé", 2009, "David Yates",
                    "De sombres secrets dévoilés pour faire face à la bataille finale")

    );

    public void PrintDescriptionInDesorder() {
        for (Movie movie : movies) {
            String description = movie.getDescription();
            List<String> words = new ArrayList<>(Arrays.asList(description.split(" ")));
            Collections.shuffle(words);
            System.out.println(String.join(" ", words));
        }
    }
    String GetMovieTitleByDirector(String director){
        for (Movie movie : movies) {
            if (movie.getRealistor().equals(director)) {
                return movie.getTitle();
            }
        }
        return "Aucun film trouvé";
    }

    List<String> GetMovieTitleWithReleaseYearPair(){
        List<String> movieTitleWithReleaseYearPair = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.releaseYear % 2 == 0) {
                movieTitleWithReleaseYearPair.add(movie.getTitle() + "(" + movie.getReleaseYear() + ")" );
            }
        }
        return movieTitleWithReleaseYearPair;
    }

    List<String> GetMovieTitleWithReleaseYearOdd(){
        List<String> movieTitleWithReleaseYearPair = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.releaseYear % 2 != 0) {
                movieTitleWithReleaseYearPair.add(movie.getTitle() + "(" + movie.getReleaseYear() + ")" );
            }
        }
        return movieTitleWithReleaseYearPair;
    }
    void printMoviesByPartOfDescription(String part) {
        for (Movie movie : movies) {
            if (movie.getDescription().contains(part)) {
                System.out.println(movie.getTitle());
            }
        }
    }

    String[] get3FirstWordsDescription() {
        String[] firstWords = new String[movies.size()];
        for (int i = 0; i < movies.size(); i++) {
            String[] words = movies.get(i).getDescription().split(" ");
            firstWords[i] = String.join(" ", Arrays.copyOfRange(words, 0, Math.min(3, words.length)));
        }
        return firstWords;
    }
}
