package com.geekster.project.assignment.EventManagementSystem.Service;

import com.geekster.project.assignment.EventManagementSystem.Model.Events;
import com.geekster.project.assignment.EventManagementSystem.Model.ParticipantsList;
import com.geekster.project.assignment.EventManagementSystem.Repository.EventsRepository;
import com.geekster.project.assignment.EventManagementSystem.Repository.ParticipantsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class EventsServices {

    @Autowired
    EventsRepository eventRepo;

    @Autowired
    ParticipantsListRepository participantsListRepo;

    public  String addEvent(Events e){
        eventRepo.save(e);
        return "A new event" + e.getEventId() + " " + e.getEventName() + " is added !!!";
    }

    public String addEvents(List<Events> e){
        eventRepo.saveAll(e);
        return "List of events are added !!!";
    }

    public Iterable<Events> getAllEvents(){
        return eventRepo.findAll();
    }

    public List<Events> getEventsByOrganizer(Integer organizerId){
        return eventRepo.findByOrganizerId(organizerId);
    }

    public String goLive(Integer eventId)
    {
         Events event = eventRepo.findByEventId(eventId);
         event.setStatus("LIVE");
         return "Event Status set to Live!";
    }

    public String goOpen(Integer eventId)
    {
        Events event = eventRepo.findByEventId(eventId);
        event.setStatus("OPEN");
        return "Event Status set to Open!";
    }
/*
    public List<Events> getAllUpcomingEvents()
    {
        Iterable<Events> eventsList = eventRepo.findAll();
        List<Events> upcomingevents = new ArrayList<>();
        //Iterator<Events> eventsListItr = eventsList.iterator();
        for(eventsListItr.next())
        {
            if(eventsList.get(i).getEventDate().isAfter(LocalDate.now()))
            {
                upcomingevents.add(eventsList.get(i));
            }
        }
        return upcomingevents;
    }


 */
    public List<Events> getAllUserEvents(Integer employeeId)
    {
        List<ParticipantsList> userEventsList = participantsListRepo.findByEmployeeId(employeeId);
        List<Events> userEvents = new ArrayList<>();
        for(int i=0;i< userEventsList.size();i++)
        {
            Events event = eventRepo.findByEventId(userEvents.get(i).getEventId());
            userEvents.add(event);
        }
        return userEvents;
    }

    public Optional<Events> getEventById(Integer eventId){
        return eventRepo.findById(eventId);
    }

    public Iterable<Events> getEventsOnSameDate(LocalDate date){
        return eventRepo.findByEventDate(date);
    }

    public String updateEventLocationById(Integer eventId, String loc){
        Optional<Events> s = eventRepo.findById(eventId);

        if(s.isEmpty()){
           return "Event not found !!!";
        }

        Events e = s.get();
        e.setVenue(loc);
        eventRepo.save(e);
        return "Location updated for the provided event";
    }

    public String removeEventById(Integer eventId){
        Events e = eventRepo.findById(eventId).orElse(null);

        if(e==null){
            return "Id not found";
        }

        eventRepo.delete(e);

        return "Event" + e.getEventId() + " is removed !!!";
    }

    public List<Events> getEventsByCategory(String eventCategory)
    {
        return eventRepo.findByEventCategory(eventCategory);
    }

    public List<Events> getPendingEventsForApproval(String status)
    {
        return eventRepo.findByStatus(status);
    }
}
