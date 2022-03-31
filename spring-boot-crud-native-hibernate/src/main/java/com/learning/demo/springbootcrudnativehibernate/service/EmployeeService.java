package com.learning.demo.springbootcrudnativehibernate.service;

import com.learning.demo.springbootcrudnativehibernate.dao.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();

    public Employee getEmployeeById(int id);

    public void saveOrUpdateEmployee(Employee employee);

    public void deleteEmployeeById(int id);

}
