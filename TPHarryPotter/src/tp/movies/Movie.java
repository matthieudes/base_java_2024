package tp.movies;

import java.util.List;

public class Movie {
    String title;
    String realistor;
    int releaseYear;
    String description;

    public Movie(String title,  int releaseYear,String realistor, String description) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.realistor = realistor;
        this.description = description;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRealistor() {
        return realistor;
    }

    public void setRealistor(String realistor) {
        this.realistor = realistor;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
