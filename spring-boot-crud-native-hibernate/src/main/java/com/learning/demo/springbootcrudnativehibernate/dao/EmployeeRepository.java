package com.learning.demo.springbootcrudnativehibernate.dao;

import org.hibernate.Session;
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

        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("from Employee", Employee.class);

        List<Employee> EmployeeList = query.getResultList();

        return EmployeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {

        Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);

    }

    @Override
    public void deleteEmployeeById(int id) {

        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Employee where id=:employeeId");

        query.setParameter("employeeId", id);

        query.executeUpdate();

    }
}
