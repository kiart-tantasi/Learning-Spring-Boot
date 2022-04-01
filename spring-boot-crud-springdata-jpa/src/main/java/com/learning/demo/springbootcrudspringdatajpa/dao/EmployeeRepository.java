package com.learning.demo.springbootcrudspringdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
