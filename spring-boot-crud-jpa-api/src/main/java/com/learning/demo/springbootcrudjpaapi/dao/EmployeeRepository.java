package com.learning.demo.springbootcrudjpaapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeRepository implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getEmployees() {

        Query query = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> EmployeeList = query.getResultList();

        return EmployeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {

        Employee newEmployeedData = entityManager.merge(employee);

        System.out.println("ID in Database: " + newEmployeedData.getId());

    }

    @Override
    public void deleteEmployeeById(int id) {

        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");

        query.setParameter("employeeId", id);

        query.executeUpdate();

    }
}
