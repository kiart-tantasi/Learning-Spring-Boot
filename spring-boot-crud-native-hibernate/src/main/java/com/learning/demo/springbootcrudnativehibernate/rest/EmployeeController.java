package com.learning.demo.springbootcrudnativehibernate.rest;

import com.learning.demo.springbootcrudnativehibernate.dao.Employee;
import com.learning.demo.springbootcrudnativehibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> employees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) throw new RuntimeException("user with id " + id + " not found");

        return employee;

    }

    @PostMapping
    public String addNewEmployee(@RequestBody Employee employee) {

        employee.setId(0);

        employeeService.saveOrUpdateEmployee(employee);

        return "Employee name " + employee.getFirstName() + " is saved.";

    }

    @PutMapping
    public String updateEmployee(@RequestBody Employee employee) {

        employeeService.saveOrUpdateEmployee(employee);

        return "Employee id " + employee.getId() + " is updated.";

    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee employeeFound = employeeService.getEmployeeById(id);

        if (employeeFound == null) throw new RuntimeException("user with id " + id + " not found");

        employeeService.deleteEmployeeById(id);

        return "Employee with id " + id + " is deleted.";

    }


}
