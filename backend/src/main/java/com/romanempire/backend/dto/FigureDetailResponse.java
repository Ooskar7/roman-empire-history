package com.romanempire.backend.dto;

import com.romanempire.backend.model.Figure;

public class FigureDetailResponse {
    private Figure figure;
    private String markdownContent;

    public FigureDetailResponse(Figure figure, String markdownContent) {
        this.figure = figure;
        this.markdownContent = markdownContent;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getMarkdownContent() {
        return markdownContent;
    }
}
