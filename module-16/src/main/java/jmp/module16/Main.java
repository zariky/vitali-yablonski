package jmp.module16;

import jmp.module16.entities.Address;
import jmp.module16.entities.Employee;
import jmp.module16.entities.Status;
import jmp.module16.services.EmployeeService;
import jmp.module16.services.impl.EmployeeServiceImpl;
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
        EmployeeService employeeService = new EmployeeServiceImpl();

        employeeService.create(new Employee("1", "11", new Address("111", "1111"), Status.FULL_TIME));
        employeeService.create(new Employee("2", "22", new Address("222", "4444"), Status.PART_TIME));
        employeeService.create(new Employee("3", "33", new Address("333", "4444"), Status.FULL_TIME));

        println(employeeService.findAll());

        employeeService.close();
    }

    private static void println(List list) {
        for(Object element : list) {
            System.out.println(element);
        }
    }

}