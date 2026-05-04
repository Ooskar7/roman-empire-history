package com.romanempire.backend.controller;

import com.romanempire.backend.model.Event;
import com.romanempire.backend.service.EventService;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.error.Mark;

import com.romanempire.backend.dto.EventDetailResponse;
import com.romanempire.backend.service.MarkdownService;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class EventDetailController {

    private final EventService eventService;
    private final MarkdownService markdownService;

    public EventDetailController(EventService eventService, MarkdownService markdownService) {
        this.eventService = eventService;
        this.markdownService = markdownService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public EventDetailResponse getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        String markdownContent = markdownService.readMarkdownFile(event.getContentFile());

        return new EventDetailResponse(event, markdownContent);
    }
}
