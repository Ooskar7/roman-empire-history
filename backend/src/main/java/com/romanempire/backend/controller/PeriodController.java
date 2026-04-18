package com.romanempire.backend.controller;

import com.romanempire.backend.model.Period;
import com.romanempire.backend.service.PeriodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periods")
@CrossOrigin(origins = "*")
public class PeriodController {

    private final PeriodService periodService;

    public PeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    @GetMapping
    public List<Period> getAllPeriods() {
        return periodService.getAllPeriods();
    }

    @GetMapping("/{id}")
    public Period getPeriodById(@PathVariable Long id) {
        return periodService.getPeriodById(id);
    }
}
