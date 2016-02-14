package jmp.module10.beans;

import java.util.Date;

/**
 * The bean that contains all information about a user
 */
public class User {

    private Long id;

    private String name;

    private String surname;

    private Date birthdate;

    public User() {
    }

    public User(String name, String surname, Date birthdate) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public User(Long id, String name, String surname, Date birthdate) {
        this(name, surname, birthdate);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User {id=" + id + ", name=" + name + ", surname=" + surname + ", birthdate=" + birthdate + "}";
    }

}