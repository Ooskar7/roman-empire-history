package com.romanempire.backend.dto;

import com.romanempire.backend.model.Event;

public class EventDetailResponse {
    private Event event;
    private String markdownContent;

    public EventDetailResponse(Event event, String markdownContent) {
        this.event = event;
        this.markdownContent = markdownContent;
    }

    public Event getEvent() {
        return event;
    }

    public String getMarkdownContent() {
        return markdownContent;
    }
}
