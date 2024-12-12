package tp.books;

public class Book {
    private int numTomes ;

    private String titre;

    private String description;

    public Book() {
    }

    public Book(int nbTomes, String titre, String description) {
        this.numTomes = nbTomes;
        this.titre = titre;
        this.description = description;
    }

    public int getNumTomes() {
        return numTomes;
    }

    public void setNbTomes(int nbTomes) {
        this.numTomes = nbTomes;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
