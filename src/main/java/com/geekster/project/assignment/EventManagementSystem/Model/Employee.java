package com.geekster.project.assignment.EventManagementSystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Only alphabets are allowed with the first letter as capital")
    private String name;

    //@Enumerated(EnumType.STRING)
    private String employeeLob;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String emailId;

    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$")
    private String phoneNo;

    private String location;

    private String role;
}