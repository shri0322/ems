package com.geekster.project.assignment.EventManagementSystem.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Events")
public class Events {
    @Id
    private Integer eventId;

    private String eventName;

    private Integer organizerId;

    private String venue;

    private LocalDate eventDate;

    private LocalTime startTime;

    private String status;

    private Integer capacity;

    private String eventCategory;

    private String eventDesc;

    //@JdbcTypeCode(SqlTypes.JSON)
    //private ParticipantsList[] participantsLists;


}

