package com.romanempire.backend.controller;

import com.romanempire.backend.model.Figure;
import com.romanempire.backend.service.FigureService;
import com.romanempire.backend.service.PeriodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FigureController {

    private final FigureService figureService;
    private final PeriodService periodService;

    public FigureController(FigureService figureService, PeriodService periodService) {
        this.figureService = figureService;
        this.periodService = periodService;
    }

    @GetMapping("/api/figures")
    public List<Figure> getAllFigures() {
        return figureService.getAllFigures();
    }

    @GetMapping("/api/figures/{id}")
    public Figure getFigureById(@PathVariable Long id) {
        return figureService.getFigureById(id);
    }

    @GetMapping("/api/periods/{id}/figures")
    public List<Figure> getFiguresByPeriodId(@PathVariable Long id) {
        periodService.getPeriodById(id);
        return figureService.getFiguresByPeriodId(id);
    }
}
