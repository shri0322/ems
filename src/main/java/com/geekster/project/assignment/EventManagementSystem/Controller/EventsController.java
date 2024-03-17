package com.geekster.project.assignment.EventManagementSystem.Controller;

import com.geekster.project.assignment.EventManagementSystem.Model.Events;
import com.geekster.project.assignment.EventManagementSystem.Service.EventsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin({"http://localhost:3000"})
public class EventsController {
    @Autowired
    EventsServices eventsServices;
    @PostMapping("/addevent")
    public String addAEvent(@RequestBody Events e){
        return eventsServices.addEvent(e);
    }
    @PostMapping("/addeventlist")
    public String addEvents(@RequestBody List<Events> e){
        return eventsServices.addEvents(e);
    }
    @GetMapping("/getevents")
    public Iterable<Events> getAllEvents(){
        return eventsServices.getAllEvents();
    }
    @GetMapping("event/{id}")
    public Optional<Events> getEventById(@PathVariable Integer id){
        return eventsServices.getEventById(id);
    }

    @GetMapping("/geteventsbyorg")
    public List<Events> getEventsByOrganizer(@RequestParam Integer organizerId){
        return eventsServices.getEventsByOrganizer(organizerId);
    }

    @PostMapping("/event/golive")
    public String goLive(@RequestParam Integer eventId)
    {
        return eventsServices.goLive(eventId);
    }

    @PostMapping("/event/goopen")
    public String goOpen(@RequestParam Integer eventId)
    {
        return eventsServices.goOpen(eventId);
    }

    /*
    @GetMapping("/upcomingevents")
    public List<Events> getAllUpcomingEvents(){
        return eventsServices.getAllUpcomingEvents();
    }

     */

    @GetMapping("/getuserevents")
    public List<Events> getUserEvents(@RequestParam Integer employeeId)
    {
        return  eventsServices.getAllUserEvents(employeeId);
    }

    @GetMapping("events/date")
    public Iterable<Events> getEventsOnSameDate(@RequestParam LocalDate date){
        return eventsServices.getEventsOnSameDate(date);
    }

    @PutMapping("/event/id/{id}/location/{loc}")
    public String updateEventLocationById(@PathVariable Integer id, @PathVariable String loc){
        return eventsServices.updateEventLocationById(id, loc);
    }
    @DeleteMapping("/event/{id}")
    public String removeEventById(@PathVariable Integer id){
        return eventsServices.removeEventById(id);
    }

    @GetMapping("/events/category")
    public List<Events> getEventsByCategory(@RequestParam String eventCategory)
    {
        return eventsServices.getEventsByCategory(eventCategory);
    }

    @GetMapping("/events/pendingforapproval")
    public List<Events> getPendingEventsForApproval(@RequestParam String status)
    {
        return eventsServices.getPendingEventsForApproval(status);
    }
}
