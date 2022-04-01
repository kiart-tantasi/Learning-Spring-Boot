package com.learning.demo.springbootcrudspringdatajpa.rest;

import com.learning.demo.springbootcrudspringdatajpa.dao.Employee;
import com.learning.demo.springbootcrudspringdatajpa.service.EmployeeService;
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

        int employeeId = employee.getId();
        if (employeeId > 0) {
            Employee employeeExist = this.getEmployeeById(employeeId);
            if (employeeExist == null) throw new RuntimeException("user with id " + employeeId + " does not exist");
        }

        employeeService.saveOrUpdateEmployee(employee);

        return "Employee id " + employee.getId() + " is updated.";

    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee employeeExist = employeeService.getEmployeeById(id);

        if (employeeExist == null) throw new RuntimeException("user with id " + id + " not found");

        employeeService.deleteEmployeeById(id);

        return "Employee with id " + id + " is deleted.";

    }


}
