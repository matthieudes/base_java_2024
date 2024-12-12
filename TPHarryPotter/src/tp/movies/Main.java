package tp.movies;

import tp.actors.ActorFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MovieFactory movieFactory = new MovieFactory();
        //movieFactory.PrintDescriptionInDesorder();
        //System.out.println(movieFactory.GetMovieTitleByDirector("David Yates"));
        //System.out.println(movieFactory.GetMovieTitleWithReleaseYearPair());
        //System.out.println(movieFactory.GetMovieTitleWithReleaseYearOdd());
        //movieFactory.printMoviesByPartOfDescription("secrets");
        System.out.println(Arrays.toString(movieFactory.get3FirstWordsDescription()));
    }
}
