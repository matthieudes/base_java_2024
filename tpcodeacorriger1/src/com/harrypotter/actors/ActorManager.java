package com.harrypotter.actors;

import java.sql.SQLException;
import java.time.Year;
import java.util.List;

public interface ActorManager {

    List<NameAge> getAgeOfActors() throws SQLException;
    NameAge getTheOldestActor() throws SQLException;
    List<Actor> getSomeActorsByFirstLetterRole(char firstLetter) throws SQLException;
    List<Actor> getActorsBornAfterACertainYear(Year year) throws SQLException;
    NameAge getTheYoungestActor() throws SQLException;
}
