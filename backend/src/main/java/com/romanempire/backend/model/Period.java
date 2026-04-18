package com.romanempire.backend.model;

public class Period {
    private Long id;
    private String name;
    private int startYear;
    private int endYear;
    private String description;
    private String capital;
    private String governmentType;
    private String keyFigure;

    public Period(Long id, String name, int startYear, int endYear, String description,
                  String capital, String governmentType, String keyFigure){
        this.id = id;
        this.name = name;
        this.startYear = startYear;
        this.endYear = endYear;
        this.description = description;
        this.capital = capital;
        this.governmentType = governmentType;
        this.keyFigure = keyFigure;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public String getDescription() {
        return description;
    }

    public String getCapital() {
        return capital;
    }

    public String getGovernmentType() {
        return governmentType;
    }

    public String getKeyFigure() {
        return keyFigure;
    }
}
