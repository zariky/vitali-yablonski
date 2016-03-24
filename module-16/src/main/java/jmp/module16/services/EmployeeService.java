package jmp.module16.services;

import jmp.module16.entities.Employee;
import java.util.List;

public interface EmployeeService {

    public Employee create(Employee employee);

    public Employee update(Employee employee);

    public void delete(Employee employee);

    public List<Employee> findAll();

    public Employee findById(Long id);

    public void close();

}