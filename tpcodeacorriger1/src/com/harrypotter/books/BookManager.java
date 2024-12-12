package com.harrypotter.books;

import java.sql.SQLException;
import java.util.List;

public interface BookManager {

    List<Book> getBooks() throws SQLException;
    Book getBookByTitle(String title) throws SQLException;
    String[] getBookTitles() throws SQLException;;
    List<String> getPartOfBookDescriptions(int numberOfWords) throws SQLException;
    List<String> getSomeDescriptions(String word) throws SQLException;
    int getSumOfLengthDescriptions() throws SQLException;
    List<Book> getBooksWithEvenID() throws SQLException;
    List<Book> getBooksWithOddID() throws SQLException;
}
