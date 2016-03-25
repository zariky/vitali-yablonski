package jmp.module16;

import jmp.module16.entities.Employee;
import jmp.module16.entities.EmployeeAddress;
import jmp.module16.entities.EmployeePersonalInfo;
import jmp.module16.entities.EmployeeStatus;
import jmp.module16.entities.Project;
import jmp.module16.entities.Unit;
import jmp.module16.services.EmployeeService;
import jmp.module16.services.ProjectService;
import jmp.module16.services.UnitService;
import jmp.module16.services.impl.EmployeeServiceImpl;
import jmp.module16.services.impl.ProjectServiceImpl;
import jmp.module16.services.impl.UnitServiceImpl;
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
        ProjectService projectService = null;
        UnitService unitService = null;
        try {
            employeeService = new EmployeeServiceImpl();
            projectService = new ProjectServiceImpl();
            unitService = new UnitServiceImpl();

            System.out.println("\n\nEmployeeService");
            testEmployeeService_CRUD(employeeService);

            System.out.println("\n\nProjectService");
            testProjectService_CRUD(projectService, employeeService);

            System.out.println("\n\nUnitService");
            testUnitService_CRUD(unitService, employeeService);
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

    private static void testEmployeeService_CRUD(EmployeeService employeeService ) {
        println("All employees before insert:", employeeService.findAll());

        for (int index = 1; index < 6; index++) {
            EmployeeAddress address = new EmployeeAddress("city-" + index, "street-" + index);
            EmployeePersonalInfo personalInfo = new EmployeePersonalInfo("characteristics-" + index);
            Employee employee = new Employee("firstName-" + index, "lastName-" + index, address, EmployeeStatus.FULL_TIME, personalInfo);
            employeeService.create(employee);
        }

        println("All employees after insert:", employeeService.findAll());

        Employee employee3 = employeeService.findById(3L);
        println("Find employee by id(3):", employee3);

        employee3.setFirstName("firstName-33");
        employee3.getPersonalInfo().setCharacteristics("characteristics-33");
        employee3 = employeeService.update(employee3);
        println("Update employee with id : 3:", employee3);

        employeeService.delete(employeeService.findById(2L));
        employeeService.delete(employee3);
        employeeService.delete(employeeService.findById(4L));
        println("Delete employees with id : 2, 3, 4.");

        println("All employees after delete employees with id : 2, 3, 4:", employeeService.findAll());
    }

    private static void testProjectService_CRUD(ProjectService projectService,EmployeeService employeeService ) {
        println("All projects before insert:", projectService.findAll());

        for (int index = 1; index < 4; index++) {
            projectService.create(new Project("name-" + index));
        }

        println("All projects after insert:", projectService.findAll());

        Project project2 = projectService.findById(2L);
        println("Find project by id(2):", project2);

        project2.setName("name-22");
        project2 = projectService.update(project2);
        println("Update project with id : 2:", project2);

        projectService.delete(project2);
        projectService.delete(projectService.findById(3L));
        println("Delete project with id : 2, 3.");

        println("All projects after delete projects with id : 2, 3:", projectService.findAll());

        projectService.findById(1L).setEmployees(employeeService.findAll());
        println("All projects after assign employees to project with id : 1:", projectService.findAll());
    }

    private static void testUnitService_CRUD(UnitService unitService,EmployeeService employeeService ) {
        println("All units before insert:", unitService.findAll());

        for (int index = 1; index < 4; index++) {
            unitService.create(new Unit("name-" + index));
        }

        println("All units after insert:", unitService.findAll());

        Unit unit2 = unitService.findById(2L);
        println("Find unit by id(2):", unit2);

        unit2.setName("name-22");
        unit2 = unitService.update(unit2);
        println("Update unit with id : 2:", unit2);

        unitService.delete(unit2);
        println("Delete unit with id : 2.");

        println("All units after delete unit with id : 2:", unitService.findAll());

        unitService.findById(1L).setEmployees(employeeService.findAll());
        println("All units after assign employees to unit with id : 1:", unitService.findAll());
    }

    private static void println(String title) {
        System.out.println("-----------------------------------------------");
        System.out.println(title);
    }

    private static void println(String title, Object object) {
        println(title);
        System.out.println(object);
    }

    private static void println(String title, List list) {
        println(title);
        for(Object element : list) {
            System.out.println(element);
        }
        System.out.println("Count: " + list.size());
    }

}