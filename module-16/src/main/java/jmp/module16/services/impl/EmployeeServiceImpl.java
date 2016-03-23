package jmp.module16.services.impl;

import jmp.module16.entities.Employee;
import jmp.module16.services.EmployeeService;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeServiceImpl extends AbstractServiceImpl implements EmployeeService {

    public Employee create(Employee employee1){
        em.getTransaction().begin();
        Employee employee = em.merge(employee1);
        em.getTransaction().commit();
        return employee;
    }

    public List<Employee> findAll(){
        TypedQuery<Employee> namedQuery = em.createNamedQuery("Employee.findAll", Employee.class);
        return namedQuery.getResultList();
    }

}