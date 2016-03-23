package jmp.module16.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
   	@JoinTable(name="employee_project",
   	           joinColumns=@JoinColumn(name="project_id"),
               inverseJoinColumns=@JoinColumn(name="employee_id")
   	)
    private List<Employee> employees;

    public Project() {}

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, List<Employee> employees) {
        this.name = name;
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
        return "Project { id = " + id + ", name = " + name + ", employees = " + employees + "}";
    }

}