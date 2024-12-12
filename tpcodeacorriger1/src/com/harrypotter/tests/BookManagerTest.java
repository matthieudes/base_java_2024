package com.harrypotter.tests;

import com.harrypotter.books.Book;
import com.harrypotter.books.BookManager;
import com.harrypotter.books.BookManagerImpl;
import com.harrypotter.utils.DataConnect;

import java.sql.Connection;
import java.sql.SQLException;

public class BookManagerTest {
    public static void main(String[] args) {

        try(Connection con = DataConnect.getConnection()) {
            System.out.println(con);
            BookManager bm = new BookManagerImpl(con);
            System.out.println("----------Liste des livres----------");
            for(Book b:bm.getBooks()) {
                System.out.println(b);
            }

            System.out.println(bm.getBookByTitle("Harry Potter et les reliques de la mort"));
            System.out.println("----------Titre des livres----------");
            for(String title:bm.getBookTitles()){
                System.out.println(title);
            }

            System.out.println("----------5 premiers mots des descriptions----------");
            for(String partDesc:bm.getPartOfBookDescriptions(5)){
                System.out.println(partDesc);
            }

            System.out.println("----------3 premiers mots des descriptions----------");
            for(String partDesc:bm.getPartOfBookDescriptions(3)){
                System.out.println(partDesc);
            }

            System.out.println("----------descriptions contenant le mot Harry----------");
            for(String desc:bm.getSomeDescriptions("Harry")){
                System.out.println(desc);
            }

            System.out.println("----------descriptions contenant le mot Sirius----------");
            for(String desc:bm.getSomeDescriptions("Sirius")){
                System.out.println(desc);
            }

            System.out.println("-----Somme des tailles des descriptions-----");
            System.out.println(bm.getSumOfLengthDescriptions());

            System.out.println("-----Livres dont l'ID est pair-----");
            for(Book b:bm.getBooksWithEvenID()){
                System.out.println(b);
            }

            System.out.println("-----Livres dont l'ID est impair-----");
            for(Book b: bm.getBooksWithOddID()){
                System.out.println(b);
            }
        }catch(ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }
    }
}
