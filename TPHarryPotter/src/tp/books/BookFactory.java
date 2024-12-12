package tp.books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookFactory {
    private List<Book> books = Arrays.asList(
            new Book(1, "Harry Potter à l'Ecole des Sorciers", "\"Que cache la trappe du troisième étage ?\""),
            new Book(2, "Harry Potter et la Chambre des Secrets",
                    "\"Harry résoudra t'il le mystère de la chambre des secrets ?\""),
            new Book(3, "Harry Potter et le Prisonnier d'Azkaban", "\"Qui est Sirius Black ?\""),
            new Book(4, "Harry Potter et la Coupe de Feu", "\"Qui gagnera le tournoi des trois sorciers ?\""),
            new Book(5, "Harry Potter et l'Ordre du Phénix",
                    "\"Harry et ses amis réussiront-ils à sauver Sirius Black (Harry en a rêvé) ?\""),
            new Book(6, "Harry Potter et le Prince de Sang-Mêlé", "\"Qui est le Prince de Sang-Mêlé ?\""),
            new Book(7, "Harry Potter et les Reliques de la Mort",
                    "\"Harry parviendra-t-il à retrouver tous les horcruxes et à les détruire ?\"")
    );

    public BookFactory() {
    }

    List<Book> GetBooks() {
        return books;
    }

    void PrintBookTitles() {
        for (Book book : books) {
            System.out.println(book.getTitre());
        }
    }

    void PrintTome1And7() {
        for (Book book : books) {
            if ( book.getNumTomes() == 1 || book.getNumTomes() == 7) {
                System.out.println(book.getTitre());
            }
        }
    }

    String GetTitleInAString() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.getTitre());
            if (book != books.get(books.size() - 1)) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    int GetTomeNumSum(){
        int sum = 0;
        for (Book book : books) {
            sum += book.getNumTomes();
        }
        return sum;
    }

    List<String> GetSomeDescriptions(String word) {
        List<String> descriptions = new ArrayList<>();
        for (Book book : books) {
            if (book.getDescription().contains(word)) {
                descriptions.add(book.getDescription());
            }
        }
        if (descriptions.isEmpty()) {
            System.out.println("Aucune description ne contient le mot " + word);
        }
        return descriptions;
    }

    int[] GetTitlesSize() {
        int[] sizes = new int[books.size()];
        for (Book book : books) {
            sizes[book.getNumTomes()-1] = book.getTitre().length();
        }
        return sizes;
    }

    void PrintLongestTitles (int[] sizes) {
        int max = 0;
        for (int size : sizes) {
            if (size > max) {
                max = size;
            }
        }
        for (Book book : books) {
            if (book.getTitre().length() == max) {
                System.out.println(book.getTitre());
            }
        }
    }

    void PrintShortestTitles(int[] sizes) {
        int min = sizes[0];
        for (int size : sizes) {
            if (size < min) {
                min = size;
            }
        }
        for (Book book : books) {
            if (book.getTitre().length() == min) {
                System.out.println(book.getTitre());
            }
        }
    }
}
