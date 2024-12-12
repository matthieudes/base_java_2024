package com.harrypotter.movies;

import java.time.Year;

public class Movie {
    private int ID;
    private String title;
    private Year yearOfRelease;
    private String director;
    private String description;

    public Movie(String title, Year yearOfRelease, String director) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
