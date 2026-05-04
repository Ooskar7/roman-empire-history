package com.romanempire.backend.model;

public class Event {
    private Long id;
    private String title;
    private int year;
    private String shortDescription;
    private String longDescription;
    private String location;
    private String imageUrl;
    private String contentFile;
    private Long periodId;

    public Event(Long id, String title, int year, String shortDescription,
                 String longDescription, String location, String imageUrl,
                 String contentFile, Long periodId) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.location = location;
        this.imageUrl = imageUrl;
        this.contentFile = contentFile;
        this.periodId = periodId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getLocation() {
        return location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getContentFile() {
        return contentFile;
    }

    public Long getPeriodId() {
        return periodId;
    }
}
