package jmp.module16;

import jmp.module16.entities.EmployeeAddress;
import jmp.module16.entities.Employee;
import jmp.module16.entities.EmployeePersonalInfo;
import jmp.module16.entities.EmployeeStatus;
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
        EmployeeService employeeService = null ;
        try {
            employeeService = new EmployeeServiceImpl();

            employeeService.create(new Employee("1-", "11", new EmployeeAddress("111", "1111"), EmployeeStatus.FULL_TIME, new EmployeePersonalInfo("11111")));
            employeeService.create(new Employee("2-", "22", new EmployeeAddress("222", "2222"), EmployeeStatus.PART_TIME, new EmployeePersonalInfo("22222")));
            employeeService.create(new Employee("3-", "33", new EmployeeAddress("333", "3333"), EmployeeStatus.FULL_TIME, new EmployeePersonalInfo("33333")));

            println(employeeService.findAll());
        } finally {
            if (employeeService != null) {
                employeeService.close();
            }
        }

    }

    private static void println(List list) {
        for(Object element : list) {
            System.out.println(element);
        }
    }

}