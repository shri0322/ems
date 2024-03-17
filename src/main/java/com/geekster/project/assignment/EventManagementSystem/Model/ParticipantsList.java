package com.geekster.project.assignment.EventManagementSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ParticipantsList")
public class ParticipantsList {


    private Integer eventId;

    @Id
    private Integer employeeId;

    private String name;

    private String employeeLob;

    private String emailId;

    private String location;

    private String role;

}
