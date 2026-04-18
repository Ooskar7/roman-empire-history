package com.romanempire.backend.service;

import com.romanempire.backend.exception.ResourceNotFoundException;
import com.romanempire.backend.model.Period;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodService {

    private final List<Period> periods = List.of(
        new Period(
                1L,
                "Roman Monarchy",
                -753,
                -509,
                "The traditional first phase of Roman history, during which Rome was ruled by kings.",
                "Rome",
                "Monarchy",
                "Romulus"
        ),
        new Period(
                2L,
                "Roman Republic",
                -509,
                -27,
                "The period in which Rome developed republican institutions and expanded across the Mediterranean.",
                "Rome",
                "Republic",
                "Julius Caesar"
        ),
        new Period(
                3L,
                "Roman Empire",
                -27,
                476,
                "The period beginning with Augustus, characterized by imperial rule and ending in the fall of the Western Roman Empire.",
                "Rome",
                "Empire",
                "Augustus"
        )
    );

    public List<Period> getAllPeriods() {
        return periods;
    }

    public Period getPeriodById(Long id) {
        for (Period period : periods) {
            if (period.getId().equals(id)) {
                return period;
            }
        }
        throw new ResourceNotFoundException("Period with id " + id + " not found.");
    }
}
