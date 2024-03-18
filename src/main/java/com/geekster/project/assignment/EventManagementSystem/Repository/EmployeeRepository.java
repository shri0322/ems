package com.geekster.project.assignment.EventManagementSystem.Repository;

import com.geekster.project.assignment.EventManagementSystem.Model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    List<Employee> findByRole(String role);
}

