package com.romanempire.backend.service;

import com.romanempire.backend.exception.ResourceNotFoundException;
import com.romanempire.backend.model.Figure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FigureService {

    private final List<Figure> figures = List.of(
            new Figure(
                    1L,
                    "Romulus",
                    -771,
                    -717,
                    "Founder and first king of Rome",
                    "Legendary founder of Rome and traditionally its first king.",
                    "According to Roman tradition, Romulus was the founder of Rome and its first king. His story, deeply tied to that of his twin brother Remus, became one of the central myths of Roman identity. He symbolized the origins of Roman political and military power.",
                    "/images/figures/romulus.png",
                    1L
            ),
            new Figure(
                    2L,
                    "Julius Caesar",
                    -100,
                    -44,
                    "General, statesman, and dictator",
                    "A central figure in the fall of the Roman Republic.",
                    "Julius Caesar was a Roman general, politician, and writer whose actions transformed the Roman Republic. His military campaigns expanded Rome’s territories, and his accumulation of power contributed to the collapse of republican institutions and the rise of imperial rule.",
                    "/images/figures/julius_caesar.png",
                    2L
            ),
            new Figure(
                    3L,
                    "Cicero",
                    -106,
                    -43,
                    "Statesman, orator, and philosopher",
                    "One of the greatest Roman speakers and defenders of the Republic.",
                    "Cicero was a Roman statesman, lawyer, philosopher, and orator. He is especially important for his speeches, letters, and political writings, as well as for his defense of republican government during the final crises of the Roman Republic.",
                    "/images/figures/cicero.jpg",
                    2L
            ),
            new Figure(
                    4L,
                    "Augustus",
                    -63,
                    14,
                    "First Roman emperor",
                    "The founder of the Roman Empire and its first emperor.",
                    "Augustus, born Octavian, became the first Roman emperor after defeating his rivals in the civil wars that followed Julius Caesar’s assassination. His rule marked the transition from Republic to Empire and established a political order that shaped Roman history for centuries.",
                    "/images/figures/augustus.jpg",
                    3L
            ),
            new Figure(
                    5L,
                    "Constantine I",
                    272,
                    337,
                    "Emperor",
                    "A major emperor associated with Christianity and imperial transformation.",
                    "Constantine I, also known as Constantine the Great, was a Roman emperor whose reign had profound consequences for the empire. He is especially known for his association with the legalization of Christianity and for founding Constantinople, which became a major imperial center.",
                    "/images/figures/constantine_I.jpg",
                    3L
            )
    );

    public List<Figure> getAllFigures() {
        return figures;
    }

    public Figure getFigureById(Long id) {
        return figures.stream()
                .filter(figure -> figure.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Figure with id " + id + " not found."));
    }

    public List<Figure> getFiguresByPeriodId(Long periodId) {
        return figures.stream()
                .filter(figure -> figure.getPeriodId().equals(periodId))
                .collect(Collectors.toList());
    }
}
