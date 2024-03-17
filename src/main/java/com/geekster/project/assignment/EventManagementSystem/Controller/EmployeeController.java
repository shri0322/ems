package com.geekster.project.assignment.EventManagementSystem.Controller;

import com.geekster.project.assignment.EventManagementSystem.Model.Employee;
import com.geekster.project.assignment.EventManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin({"http://localhost:3000"})
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/login/user")
    public String userLogin(@RequestParam Integer employeeId,@RequestParam String password){
        return employeeService.userLogin(employeeId,password);
    }

    @PostMapping("/login/org")
    public String orgLogin(@RequestParam Integer employeeId,@RequestParam String password){
        return employeeService.orgLogin(employeeId,password);
    }

    @PostMapping("/login/admin")
    public String adminLogin(@RequestParam Integer employeeId,@RequestParam String password){
        return employeeService.adminLogin(employeeId,password);
    }

    @PostMapping("/user/createprofile")
    public String userRegistration(@RequestBody Employee e){
        return employeeService.addEmployee(e);
    }

    @GetMapping("/getallusers")
    public Iterable<Employee> allEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/user/{id}")
    public Optional<Employee> getUserById(@PathVariable Integer employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

}

