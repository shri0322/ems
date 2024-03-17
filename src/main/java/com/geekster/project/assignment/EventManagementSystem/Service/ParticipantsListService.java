package com.geekster.project.assignment.EventManagementSystem.Service;

import com.geekster.project.assignment.EventManagementSystem.Model.ParticipantsList;
import com.geekster.project.assignment.EventManagementSystem.Repository.ParticipantsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParticipantsListService {

    @Autowired
    ParticipantsListRepository participantsListRepository;

    public Iterable<ParticipantsList> getAllParticipants(){
        return participantsListRepository.findAll();
    }

    public Iterable<ParticipantsList> getEventParticipants(Integer eventId){
        return participantsListRepository.findByEventId(eventId);
    }
    public List<ParticipantsList> getEventParticipationAtLocation(Integer eventId, String location) {
        List<ParticipantsList> participantsLists = participantsListRepository.findByEventId(eventId);
        List<ParticipantsList> locWiseList = new ArrayList<>();
        for(int i=0;i< participantsLists.size();i++)
        {
            ParticipantsList loc = participantsListRepository.findByLocation(location);
            locWiseList.add(loc);
        }
        return locWiseList;
    }

    public String userRegister(ParticipantsList p){
        participantsListRepository.save(p);
        return "Registration Successful for event " + p.getEventId();
    }

}
