package jmp.module03.beans;

import static jmp.module03.utils.Constants.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

/**
 * The bean that contains all information about a Person
 */
@Entity
@NamedQueries({
    @NamedQuery(name = PERSON_FIND_ALL_QUERY, query = "SELECT p from Person p"),
    @NamedQuery(name = PERSON_FIND_BY_NAME_QUERY, query="SELECT p from Person p WHERE p.name = :" + PERSON_NAME_ATTRIBUTE)
})
public class Person implements Serializable {

    /**
     * The id of person
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The name of person
     */
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person { name='" + name + "' }";
    }

}