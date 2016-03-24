package jmp.module16.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Unit.findAll", query = "SELECT u from Unit u")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
   	@JoinColumn(referencedColumnName="id")
   	private List<Employee> employees;

    public Unit() {}

    public Unit(String name) {
        this.name = name;
        this.employees = new ArrayList<Employee>();
    }

    public Unit(String name, List<Employee> employees) {
        this(name);
        this.employees = employees;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Unit { id = " + id + ", name = " + name + ", employees = " + employees + "}";
    }

}