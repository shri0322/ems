package com.geekster.project.assignment.EventManagementSystem.Controller;

import com.geekster.project.assignment.EventManagementSystem.Model.ParticipantsList;
import com.geekster.project.assignment.EventManagementSystem.Service.ParticipantsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"http://localhost:3000"})
public class ParticipantsListController {
    @Autowired
    ParticipantsListService participantsListService;

    @GetMapping("/allparticipants")
    public Iterable<ParticipantsList> allParticipants()
    {
        return participantsListService.getAllParticipants();
    }
    @GetMapping("/eventparticipants")
    public Iterable<ParticipantsList> eventParticipants(@RequestParam Integer eventId)
    {
        return participantsListService.getEventParticipants(eventId);
    }

    @GetMapping("/participantsatloc")
    public Iterable<ParticipantsList> participantsbyLoc(@RequestParam Integer eventId,@RequestParam String location)
    {
        return participantsListService.getEventParticipationAtLocation(eventId,location);
    }

    @PostMapping("/user/reg")
    public String registerUser(@RequestBody ParticipantsList p)
    {
        return participantsListService.userRegister(p);
    }
}
