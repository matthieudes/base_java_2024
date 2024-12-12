package com.harrypotter.books;

public class Book {

    private int ID;
    private String title;
    private String description;

    public Book(int ID, String title, String description) {
        this.ID = ID;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "\uD83D\uDCD2 Book{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
