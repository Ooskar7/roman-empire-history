package com.romanempire.backend.service;

import com.romanempire.backend.exception.ResourceNotFoundException;
import com.romanempire.backend.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final List<Event> events = List.of(
            new Event(
                    1L,
                    "Founding of Rome",
                    -753,
                    "According to tradition, Rome was founded by Romulus.",
                    "According to Roman tradition, the city of Rome was founded in 753 BC by Romulus, who became its first king. The story of Romulus and Remus became one of the central foundation myths of Roman identity and political culture.",
                    "Rome",
                    "/images/events/founding_of_rome.png",
                    1L
            ),
            new Event(
                    2L,
                    "Expulsion of the Kings",
                    -509,
                    "The Roman monarchy ended and the Republic was established.",
                    "The expulsion of the last Roman king, Tarquinius Superbus, traditionally marked the end of the Roman Monarchy and the beginning of the Roman Republic. This event became a foundational political memory for the Romans, who strongly associated kingship with tyranny afterward.",
                    "Rome",
                    "/images/events/expulsion_of_the_kings.png",
                    1L
            ),
            new Event(
                    3L,
                    "Twelve Tables",
                    -451,
                    "The first attempt to create a code of law for Rome.",
                    "The Twelve Tables were an early codification of Roman law, traditionally created in the mid-5th century BC. They were significant because they made important legal rules more visible and stable, reducing arbitrary interpretation by elites.",
                    "Rome",
                    "/images/events/twelve_tables.png",
                    2L
            ),
            new Event(
                    4L,
                    "Assassination of Julius Caesar",
                    -44,
                    "Caesar was assassinated by a group of senators.",
                    "Julius Caesar was assassinated on the Ides of March in 44 BC by a group of senators who feared his growing power. The assassination did not restore the Republic as the conspirators hoped; instead, it accelerated the conflicts that led to the rise of Augustus and the Roman Empire.",
                    "Rome",
                    "/images/events/assassination_julius_caesar.jpg",
                    2L
            ),
            new Event(
                    5L,
                    "Beginning of Augustus' Rule",
                    -27,
                    "Octavian became Augustus, marking the beginning of the Empire.",
                    "In 27 BC, Octavian received the title Augustus, a turning point traditionally seen as the beginning of the Roman Empire. Although republican institutions formally continued, political power became increasingly concentrated in the hands of the emperor.",
                    "Rome",
                    "/images/events/augustus_rule.png",
                    3L
            ),
            new Event(
                    6L,
                    "Fall of the Western Roman Empire",
                    476,
                    "Romulus Augustulus was deposed, traditionally marking the fall of the Western Empire.",
                    "In AD 476, the deposition of Romulus Augustulus by Odoacer is traditionally used to mark the fall of the Western Roman Empire. Although the Eastern Roman Empire continued for many centuries, this event became a major symbolic dividing line in European history.",
                    "Ravenna",
                    "/images/events/fall_roman_empire.jpg",
                    3L
            )
    );

    public List<Event> getEventsByPeriodId(Long periodId) {
        return events.stream()
                .filter(event -> event.getPeriodId().equals(periodId))
                .collect(Collectors.toList());
    }

    public Event getEventById(Long id) {
        return events.stream()
                .filter(event -> event.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Event with id " + id + " not found."));
    }

    public List<Event> getAllEvents() {
        return events;
    }
}
