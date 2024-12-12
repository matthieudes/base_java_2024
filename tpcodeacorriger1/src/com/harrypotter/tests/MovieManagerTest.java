package com.harrypotter.tests;

import com.harrypotter.movies.Movie;
import com.harrypotter.movies.MovieManager;
import com.harrypotter.movies.MovieManagerImpl;
import com.harrypotter.utils.DataConnect;

import java.sql.SQLException;
import java.time.Year;

public class MovieManagerTest {

    public static void main(String[] args) {
        try {
            MovieManager mm = new MovieManagerImpl(DataConnect.getConnection());
            System.out.println("-----Titre des films parus après 2004-----");
            System.out.println(mm.getMovieTitlesByReleaseYear(Year.of(2004)));
            System.out.println("-----Nombre de films par réalisateur-----");
            for(String s:mm.getNumberOfMoviesByDirector()){
                System.out.println(s);
            }
            System.out.println("-----Films dont la description comporte le mot \"sombres\"-----");
            for(Movie m:mm.getSomeMoviesByDescription("sombres")){
                System.out.println(m);
            }
            System.out.println("-----Partie des descriptions à partir du mot \"les\"-----");
            System.out.println(mm.getPartDesc("les"));
            System.out.println("-----Partie des descriptions à partir du mot \"Poudlard\"-----");
            System.out.println(mm.getPartDesc("Poudlard"));
            System.out.println("-----Prénoms des différents réalisateurs sans doublon-----");
            System.out.println(mm.getDistinctFirstnameOfDirectors());
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
    }
}
