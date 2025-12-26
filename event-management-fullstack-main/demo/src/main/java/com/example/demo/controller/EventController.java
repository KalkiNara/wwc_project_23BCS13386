package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Event;
import com.example.demo.service.EventService;
import org.springframework.data.domain.Page;

@RestController
public class EventController {

    @Autowired
    private EventService service;

    @PostMapping("/event") // default localhost:8080/event
    public Event createEvent(@RequestBody Event event) {
        return service.createEvent(event);
    }

    @GetMapping("/getevents")
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }
    @PutMapping("/event/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
    return service.updateEvent(id, event);
}
    @DeleteMapping("/event/{id}")
    public String deleteEvent(@PathVariable Long id) {
    service.deleteEvent(id);
    return "Event deleted successfully";
}
@GetMapping("/events/sort")
public List<Event> getSortedEvents(@RequestParam String field) {
    return service.getSortedEvents(field);
}
@GetMapping("/events/page")
public Page<Event> getPaginatedEvents(
        @RequestParam int page,
        @RequestParam int size) {
    return service.getPaginatedEvents(page, size);
}

}
