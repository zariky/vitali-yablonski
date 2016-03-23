package jmp.module16.services;

import jmp.module16.entities.Employee;
import java.util.List;

public interface EmployeeService {

    public Employee create(Employee employee);

    public List<Employee> findAll();

    public void close();

}