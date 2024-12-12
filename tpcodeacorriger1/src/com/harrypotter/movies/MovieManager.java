package com.harrypotter.movies;

import java.sql.SQLException;
import java.time.Year;
import java.util.List;

public interface MovieManager {

    String getMovieTitlesByReleaseYear(Year year) throws SQLException;
    List<String> getNumberOfMoviesByDirector() throws SQLException;
    List<Movie> getSomeMoviesByDescription(String word) throws SQLException;
    List<String> getPartDesc(String word) throws SQLException;
    String getDistinctFirstnameOfDirectors() throws SQLException;
}
