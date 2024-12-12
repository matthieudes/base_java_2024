package com.harrypotter.movies;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements MovieManager {

    private Connection con;

    public MovieManagerImpl(Connection con){
        this.con = con;
    }

    @Override
    public String getMovieTitlesByReleaseYear(Year year) throws SQLException {
        StringBuilder sb = new StringBuilder();
        PreparedStatement ps = con.prepareStatement("SELECT title FROM movie WHERE yearOfRelease >= ?");
        ps.setInt(1,year.getValue());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            sb.append(rs.getString("title"));
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public List<String> getNumberOfMoviesByDirector() throws SQLException {
        List<String> result = new ArrayList<>();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT director, COUNT(title) AS numberOfMovies FROM movie GROUP BY director");
        while(rs.next()){
            result.add(rs.getString("director")+" "+rs.getInt("numberOfMovies"));
        }
        return result;
    }

    @Override
    public List<Movie> getSomeMoviesByDescription(String word) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM movie WHERE description LIKE ?");
        ps.setString(1,"%" + word + "%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Movie m = new Movie(
                    rs.getString("title"),
                    Year.of(rs.getInt("yearOfRelease")),
                    rs.getString("director"));
            m.setID(rs.getInt("ID"));
            movies.add(m);
        }
        return movies;
    }

    public List<String> getPartDesc(String word) throws SQLException{
        List<String> parts = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(
                "SELECT SUBSTRING(description,locate(?,description),length(description)-1) AS partdesc FROM movie");
        ps.setString(1,word);

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String partdesc = rs.getString("partdesc");
            parts.add(partdesc);
        }
        return parts;
    }

    @Override
    public String getDistinctFirstnameOfDirectors() throws SQLException {
        StringBuilder sb = new StringBuilder();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT DISTINCT (SUBSTRING_INDEX(director, 1, position(\"\" in director))) AS firstnameDirector FROM movie");
        while(rs.next()){
            sb.append(rs.getString("firstnameDirector"));
            sb.append(" ");
        }
        return sb.toString();
    }
}
