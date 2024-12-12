package tp.actors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ActorFactory {
    private List<Actor> actors = Arrays.asList(
            new Actor("Daniel Radcliffe", LocalDate.of(1989,7,23), "Harry Potter"),
            new Actor("Emma Watson", LocalDate.of(1990,4,15), "Hermione Granger"),
            new Actor("Rupert Grint", LocalDate.of(1988,8,24), "Ron Weasley"),
            new Actor("Alan Rickman", LocalDate.of(1946,2,21), "Severus Rogue"),
            new Actor("Tom Felton", LocalDate.of(1987,9,22), "Draco Malfoy"),
            new Actor("Bonnie Wright", LocalDate.of(1991,2,17), "Ginny Weasley"),
            new Actor("Matthew Lewis", LocalDate.of(1989,6,27), "Neville Londubat"),
            new Actor("Michael Gambon", LocalDate.of(1940,10,19), "Albus Dumbledore")
    );

    public ActorFactory() {
    }

    void PrintFirstNameInUpperCase() {

        actors.forEach(actor -> System.out.println(actor.getName().split(" ")[0].toUpperCase()));
    }

    void PrintBirthYearOfActors(){

        actors.forEach(actor -> System.out.println(actor.getBirthDate().getYear()));
    }
    String GetYoungestActor(){
        Actor youngestActor = actors.get(0);
        for (Actor actor : actors) {
            if (actor.getBirthDate().isAfter(youngestActor.getBirthDate())) {
                youngestActor = actor;
            }
        }
        return youngestActor.getName();
    }
    String GetOldestActor(){
        Actor oldestActor = actors.get(0);
        for (Actor actor : actors) {
            if (actor.getBirthDate().isBefore(oldestActor.getBirthDate())) {
                oldestActor = actor;
            }
        }
        return oldestActor.getName();
    }

    String[] GetBirthdatesInLongFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRENCH);
        String[] birthDates = new String[actors.size()];
        for (int i = 0; i < actors.size(); i++) {
            birthDates[i] = actors.get(i).getBirthDate().format(formatter);
        }
        return birthDates;
    }

    void PrintAgeOfActors(){
        LocalDate now = LocalDate.now();
        actors.forEach(actor -> System.out.println(actor.getName() + " is " + (now.getYear() - actor.getBirthDate().getYear()) + " years old"));
    }
    void PrintFirstNameAndRoleOfActors(){
        actors.forEach(actor -> System.out.println(actor.getName().split(" ")[0] + "=" + actor.getRole().split(" ")[0]));
    }
}
