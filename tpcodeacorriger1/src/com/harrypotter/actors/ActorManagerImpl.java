package com.harrypotter.actors;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class ActorManagerImpl implements ActorManager {

    private Connection con;

    public ActorManagerImpl(Connection con){
        this.con = con;
    }

    @Override
    public List<NameAge> getAgeOfActors() throws SQLException {
        List<NameAge> ages = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT CONCAT(lastname,' ', firstname) AS name, " +
                "ROUND(DATEDIFF(CURDATE(), birthdate) / 365) AS age FROM actor;");
        while(rs.next()){
            NameAge na = new NameAge(rs.getString("name"),rs.getByte("age"));
            ages.add(na);
        }
        return ages;
    }

    @Override
    public NameAge getTheOldestActor() throws SQLException {
        NameAge na = null;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT CONCAT(lastname,\" \", firstname) AS name, " +
                "round(DATEDIFF(CURDATE(), BIRTHDATE)/365) AS age FROM actor ORDER by age DESC LIMIT 1;");
        if (rs.next()){
            na = new NameAge(rs.getString("name"),rs.getByte("age"));
        }
        return na;
    }

    @Override
    public NameAge getTheYoungestActor() throws SQLException {
        NameAge na = null;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT CONCAT(lastname,\" \", firstname) AS name, " +
                "round(DATEDIFF(CURDATE(), BIRTHDATE)/365) AS age FROM actor ORDER by age ASC LIMIT 1;");
        if(rs.next()){
            na = new NameAge(rs.getString("name"),rs.getByte("age"));
        }
        return na;
    }

    @Override
    public List<Actor> getSomeActorsByFirstLetterRole(char firstLetter) throws SQLException {
        List<Actor> actors = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM actor WHERE substring(role, 1, 1) = ?");
        ps.setString(1, String.valueOf(firstLetter));
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Actor a = new Actor(rs.getString("lastname"),rs.getString("firstname"));
            a.setBirthdate(rs.getDate("birthdate"));
            a.setRole(rs.getString("role"));
            actors.add(a);
        }
        return actors;
    }

    @Override
    public List<Actor> getActorsBornAfterACertainYear(Year year) throws SQLException {
        List<Actor> actors = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM actor WHERE year(birthdate) > ?");
        ps.setInt(1,year.getValue());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Actor a = new Actor(rs.getString("lastname"),rs.getString("firstname"));
            a.setID(rs.getInt("ID"));
            a.setBirthdate(rs.getDate("birthdate"));
            a.setRole(rs.getString("role"));
            actors.add(a);
        }
        return actors;
    }
}
