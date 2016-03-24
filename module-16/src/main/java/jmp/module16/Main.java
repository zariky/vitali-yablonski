package jmp.module16;

import jmp.module16.entities.*;
import jmp.module16.services.EmployeeService;
import jmp.module16.services.ProjectService;
import jmp.module16.services.UnitService;
import jmp.module16.services.impl.EmployeeServiceImpl;
import jmp.module16.services.impl.ProjectServiceImpl;
import jmp.module16.services.impl.UnitServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class
 */
public class Main {

    /**
     * The main method
     * @param vmArguments a array of programm arguments
     */
    public static void main(String[] vmArguments) {
        EmployeeService employeeService = null ;
        UnitService unitService = null;
        ProjectService projectService = null;
        try {
            employeeService = new EmployeeServiceImpl();
            unitService = new UnitServiceImpl();
            projectService = new ProjectServiceImpl();

            Employee employee1 = new Employee("firstName-01", "lastName-01", new EmployeeAddress("city-01", "street-01"), EmployeeStatus.FULL_TIME, new EmployeePersonalInfo("characteristics-01"));
            Employee employee2 = new Employee("firstName-02", "lastName-02", new EmployeeAddress("city-02", "street-02"), EmployeeStatus.FULL_TIME, new EmployeePersonalInfo("characteristics-02"));
            Employee employee3 = new Employee("firstName-03", "lastName-03", new EmployeeAddress("city-03", "street-03"), EmployeeStatus.FULL_TIME, new EmployeePersonalInfo("characteristics-03"));

            Project project1 = projectService.create(new Project("project-01"));
            Project project2 = new Project("project-022222222");

            List<Project> projects = new ArrayList<Project>();
            projects.add(project1);
            projects.add(project2);
            employee1.setProjects(projects);

            employee1 = employeeService.create(employee1);
            employee2 = employeeService.create(employee2);
            employee3 = employeeService.create(employee3);

            println(employeeService.findAll());

            List<Employee> employees = new ArrayList<Employee>();
            employees.add(employee1);
            employees.add(employee2);
            Unit unit = new Unit("name-01", employees);

            unitService.create(unit);

            println(unitService.findAll());

            println(projectService.findAll());
        } finally {
            if (employeeService != null) {
                employeeService.close();
            }
            if (unitService != null) {
                unitService.close();
            }
            if (projectService != null) {
                projectService.close();
            }
        }

    }

    private static void println(List list) {
        for(Object element : list) {
            System.out.println(element);
        }
    }

}