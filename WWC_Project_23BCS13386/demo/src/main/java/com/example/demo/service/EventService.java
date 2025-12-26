package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    // Create
    public Event createEvent(Event event) {
        return repository.save(event);
    }

    // Read all
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    // Read by id
    public Optional<Event> getEventById(Long id) {
        return repository.findById(id);
    }
    public Event updateEvent(Long id, Event updatedEvent) {
    return repository.findById(id).map(event -> {
        event.setName(updatedEvent.getName());
        event.setDate(updatedEvent.getDate());
        event.setDescription(updatedEvent.getDescription());
        return repository.save(event);
    }).orElseThrow(() -> new RuntimeException("Event not found"));
}
    public void deleteEvent(Long id) {
    repository.deleteById(id);
}
public List<Event> getSortedEvents(String field) {
    return repository.findAll(Sort.by(Sort.Direction.ASC, field));
}
public Page<Event> getPaginatedEvents(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return repository.findAll(pageable);
}

}
