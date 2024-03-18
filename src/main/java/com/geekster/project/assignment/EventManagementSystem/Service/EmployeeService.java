package com.geekster.project.assignment.EventManagementSystem.Service;

import com.geekster.project.assignment.EventManagementSystem.Model.Employee;
import com.geekster.project.assignment.EventManagementSystem.Repository.EmployeeRepository;
import com.geekster.project.assignment.EventManagementSystem.Repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EventsRepository eventsRepository;

    public String userLogin(Integer employeeId,String password)
    {
        Employee emp = employeeRepository.findById(employeeId).orElse(null);
        if(emp==null)
        {
            return "No such User exists!";
        }else if(!Objects.equals(emp.getRole(), "User"))
        {
            System.out.println(emp.getRole());
            return "User does not have access to Login into this role";
        }
        else return "Login Successful!";
    }


    public String orgLogin(Integer employeeId,String password)
    {
        Employee emp = employeeRepository.findById(employeeId).orElse(null);
        if(emp==null)
        {
            return "No such Organizer exists!";
        }else if(!Objects.equals(emp.getRole(), "Organizer"))
        {
            System.out.println(emp.getRole());
            return "User does not have access to Login into this role";
        }
        else return "Login Successful!";
    }

    public String adminLogin(Integer employeeId,String password)
    {
        Employee emp = employeeRepository.findById(employeeId).orElse(null);
        if(emp==null)
        {
            return "No such Admin exists!";
        }else if(!Objects.equals(emp.getRole(), "Admin"))
        {
            System.out.println(emp.getRole());
            return "User does not have access to Login into this role";
        }
        else return "Login Successful!";
    }

    public String addEmployee(Employee e){
        employeeRepository.save(e);
        return "User " + e.getEmployeeId() + " is added";
    }

    public String addEmployees(List<Employee> e){
        employeeRepository.saveAll(e);
        return "List of users added !!!";
    }

    public Iterable<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllOrganisers(String role)
    {
        return employeeRepository.findByRole(role);
    }

}
