package com.romanempire.backend.controller;

import com.romanempire.backend.model.Event;
import com.romanempire.backend.service.EventService;
import com.romanempire.backend.service.PeriodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periods")
@CrossOrigin(origins = "*")
public class EventController {

    private final EventService eventService;
    private final PeriodService periodService;

    public EventController(EventService eventService, PeriodService periodService) {
        this.eventService = eventService;
        this.periodService = periodService;
    }

    @GetMapping("/{id}/events")
    public List<Event> getEventsByPeriodId(@PathVariable Long id) {
        periodService.getPeriodById(id);
        return eventService.getEventsByPeriodId(id);
    }
}
