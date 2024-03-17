package com.geekster.project.assignment.EventManagementSystem.Repository;

import com.geekster.project.assignment.EventManagementSystem.Model.Events;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventsRepository extends CrudRepository<Events,Integer> {
    List<Events> findByEventDate(LocalDate Date);
    List<Events> findByOrganizerId(Integer organizerId);
    Events findByEventId(Integer eventId);
    //List<Events> findAllEvents();
    List<Events> findByEventCategory(String eventCategory);
    List<Events> findByStatus(String status);
}
