package com.romanempire.backend.model;

public class Figure {
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    private String role;
    private String shortDescription;
    private String longDescription;
    private String imageUrl;
    private String contentFile;
    private Long periodId;

    public Figure(Long id, String name, Integer birthYear, Integer deathYear,
                  String role, String shortDescription, String longDescription,
                  String imageUrl, String contentFile, Long periodId) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.role = role;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.imageUrl = imageUrl;
        this.contentFile = contentFile;
        this.periodId = periodId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public String getRole() {
        return role;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
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
