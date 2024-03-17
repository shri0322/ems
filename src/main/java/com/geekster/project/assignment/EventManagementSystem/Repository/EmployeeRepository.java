package com.geekster.project.assignment.EventManagementSystem.Repository;

import com.geekster.project.assignment.EventManagementSystem.Model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}

