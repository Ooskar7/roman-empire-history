package com.romanempire.backend.controller;

import com.romanempire.backend.dto.FigureDetailResponse;
import com.romanempire.backend.model.Figure;
import com.romanempire.backend.service.FigureService;
import com.romanempire.backend.service.MarkdownService;
import com.romanempire.backend.service.PeriodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FigureController {

    private final FigureService figureService;
    private final PeriodService periodService;
    private final MarkdownService markdownService;

    public FigureController(
            FigureService figureService,
            PeriodService periodService,
            MarkdownService markdownService
    ) {
        this.figureService = figureService;
        this.periodService = periodService;
        this.markdownService = markdownService;
    }

    @GetMapping("/api/figures")
    public List<Figure> getAllFigures() {
        return figureService.getAllFigures();
    }

    @GetMapping("/api/figures/{id}")
    public FigureDetailResponse getFigureById(@PathVariable Long id) {
        Figure figure = figureService.getFigureById(id);
        String markdownContent = markdownService.readMarkdownFile(figure.getContentFile());

        return new FigureDetailResponse(figure, markdownContent);
    }

    @GetMapping("/api/periods/{id}/figures")
    public List<Figure> getFiguresByPeriodId(@PathVariable Long id) {
        periodService.getPeriodById(id);
        return figureService.getFiguresByPeriodId(id);
    }
}
