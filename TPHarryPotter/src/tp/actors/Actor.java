package tp.actors;

import java.time.LocalDate;
import java.util.Date;

public class Actor {
    private String name;
    private LocalDate birthDate;
    private String role;

    public Actor() {
    }

    public Actor(String name, LocalDate birthDate, String role) {
        this.name = name;
        this.birthDate = birthDate;
        this.role = role;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
