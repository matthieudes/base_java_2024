package com.harrypotter.tests;

import com.harrypotter.actors.Actor;
import com.harrypotter.actors.ActorManager;
import com.harrypotter.actors.ActorManagerImpl;
import com.harrypotter.actors.NameAge;
import com.harrypotter.utils.DataConnect;

import java.sql.SQLException;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class ActorManagerTest {
    public static void main(String[] args) {
        try {
            ActorManager am = new ActorManagerImpl(DataConnect.getConnection());
            System.out.println("----------Age des acteurs----------");
            for(NameAge na: am.getAgeOfActors()){
                System.out.println(na);
            }
            System.out.println("----------Acteur le plus jeune----------");
            System.out.println(am.getTheYoungestActor());
            System.out.println("----------Acteur le plus vieux----------");
            System.out.println(am.getTheOldestActor());

            System.out.println("----------Acteurs dont le rôle commence par la lettre 'H'----------");
            for(Actor a:am.getSomeActorsByFirstLetterRole('H')){
                System.out.println(a);
            }

            System.out.println("----------Acteurs dont le rôle commence par la lettre 'G'----------");
            for(Actor a:am.getSomeActorsByFirstLetterRole('G')){
                System.out.println(a);
            }
            System.out.println("----------Acteurs nés après 1989----------");
            for(Actor a:am.getActorsBornAfterACertainYear(Year.of(1989))){
                System.out.println(a);
            }
            System.out.println("----------Acteurs nés après 1950----------");
            for(Actor a:am.getActorsBornAfterACertainYear(Year.of(1950))){
                System.out.println(a);
            }

        }catch(ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }

    }
}
