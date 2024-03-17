package com.geekster.project.assignment.EventManagementSystem.Repository;

import com.geekster.project.assignment.EventManagementSystem.Model.ParticipantsList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantsListRepository extends CrudRepository<ParticipantsList,Integer> {

    List<ParticipantsList> findByEventId(Integer eventId);
    List<ParticipantsList> findByEmployeeId(Integer employeeId);

    ParticipantsList findByLocation(String location);
}
