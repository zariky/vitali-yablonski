package jmp.module16.services.impl;

import jmp.module16.entities.Employee;
import jmp.module16.services.EmployeeService;
import java.util.List;

public class EmployeeServiceImpl extends AbstractServiceImpl implements EmployeeService {

    @Override
    public Employee create(Employee employee){
        return merge(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return merge(employee);
    }

    @Override
    public void delete(Employee employee) {
        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();
    }

    @Override
    public List<Employee> findAll(){
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    @Override
    public Employee findById(Long id) {
        return em.find(Employee.class, id);
    }

    private Employee merge(Employee employee1) {
        em.getTransaction().begin();
        Employee employee = em.merge(employee1);
        em.getTransaction().commit();
        return employee;
    }

}