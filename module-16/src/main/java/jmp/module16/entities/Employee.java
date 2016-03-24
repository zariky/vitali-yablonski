package jmp.module16.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Employee.findAll", query = "SELECT e from Employee e")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    @Embedded
    private EmployeeAddress address;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName="id")
    private EmployeePersonalInfo personalInfo;

    @ManyToMany(cascade = CascadeType.ALL)
   	@JoinTable(name="employee_project",
               joinColumns=@JoinColumn(name="employee_id"),
               inverseJoinColumns=@JoinColumn(name="project_id")
   	)
    private List<Project> projects;

    public Employee() {}

    public Employee(String firstName, String lastName, EmployeeAddress address, EmployeeStatus status, EmployeePersonalInfo personalInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.status = status;
        this.personalInfo = personalInfo;
        this.projects = new ArrayList<Project>();
    }

    public Employee(String firstName, String lastName, EmployeeAddress address, EmployeeStatus status, EmployeePersonalInfo personalInfo, List<Project> projects) {
        this(firstName, lastName, address, status, personalInfo);
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeAddress getAddress() {
        return address;
    }

    public void setAddress(EmployeeAddress address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public EmployeePersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(EmployeePersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee { id = " + id + ", firstName = " + firstName + ", lastName = " + lastName +
               ", Address = " + address + ", status = " + status + ", PersonalInfo = " + personalInfo + "}";
    }

}