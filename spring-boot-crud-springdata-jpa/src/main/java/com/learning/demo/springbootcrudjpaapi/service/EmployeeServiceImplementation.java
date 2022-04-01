package com.learning.demo.springbootcrudjpaapi.service;

import com.learning.demo.springbootcrudjpaapi.dao.Employee;
import com.learning.demo.springbootcrudjpaapi.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        if (result.isEmpty()) throw new RuntimeException("user with id " + id + " not found");

        System.out.println("RESULT: " + result.get());

        return result.get();
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
