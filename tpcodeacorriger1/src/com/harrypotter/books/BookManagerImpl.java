package com.harrypotter.books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements BookManager {

    private Connection con;
    
    public BookManagerImpl(Connection con){

        this.con = con;
    }

    public List<Book> getBooks() throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM book");
        List<Book> books = new ArrayList<>();
        while(rs.next()){
            Book b = new Book(rs.getInt("ID"),
                    rs.getString("title"),
                    rs.getString("description"));
            books.add(b);
        }
        return books;
    }

    public Book getBookByTitle(String title) throws SQLException {
        Book b = null;
        PreparedStatement ps = con.prepareStatement("SELECT * FROM book WHERE title = ?;");
        ps.setString(1, title);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            b = new Book(rs.getInt("ID"),
                    rs.getString("title"),
                    rs.getString("description"));
        }
        return b;
    }

    public String[] getBookTitles() throws SQLException {
        String[] titles;
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("SELECT title FROM book");
        int size = 0;
        if(rs.last()){
            size = rs.getRow();
            rs.beforeFirst();
        }
        titles = new String[size];
        int count = 0;
        while(rs.next()){
            titles[count++] = rs.getString("title");
        }
        return titles;
    }

    public List<String> getPartOfBookDescriptions(int numberOfWords) throws SQLException {
        List<String> parts = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(
                "SELECT SUBSTRING_INDEX(description, ' ', ?) AS part FROM book");
        ps.setInt(1, numberOfWords);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            parts.add(rs.getString("part"));
        }
        return parts;
    }

    @Override
    public List<String> getSomeDescriptions(String word) throws SQLException {
        List<String> descriptions = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT description FROM book WHERE description LIKE ?");
        ps.setString(1, "%" + word + "%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            descriptions.add(rs.getString("description"));
        }
        return descriptions;
    }

    @Override
    public int getSumOfLengthDescriptions() throws SQLException {
        int result = 0;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT SUM(LENGTH(description)) AS sumLength FROM book");
        if(rs.next()){
            result = rs.getInt("sumLength");
        }
        return result;
    }

    @Override
    public List<Book> getBooksWithEvenID() throws SQLException {
        List<Book> books = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM book WHERE id % 2 = 0");
        while(rs.next()){
           Book b = new Book(rs.getInt("id"),
                   rs.getString("title"),
                   rs.getString("description"));
           books.add(b);
        }
        return books;
    }

    @Override
    public List<Book> getBooksWithOddID() throws SQLException {
        List<Book> books = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM book WHERE id%2!=0");
        while(rs.next()){
            Book b = new Book(rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"));
            books.add(b);
        }
        return books;
    }
}
