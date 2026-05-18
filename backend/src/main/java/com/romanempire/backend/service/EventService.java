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
                    "Deposition of Amulius",
                    -754,
                    "Beginnings of Roman mythology and first apparition of Romulus and Remus.",
                    "In Roman mythology, Amulius was king of Alba Longa who ordered the death of his infant, twin grandnephews Romulus, the eventual founder and king of Rome, and Remus. He was deposed and killed by them after they survived and grew to adulthood",
                    "Rome",
                    "/images/events/monarchy/deposition-of-amulius.png",
                    "content/events/monarchy/deposition-of-amulius.md",
                    1L
            ),
            new Event(
                    2L,
                    "Founding of Rome",
                    -753,
                    "According to tradition, Rome was founded by Romulus.",
                    "According to Roman tradition, the city of Rome was founded in 753 BC by Romulus, who became its first king. The story of Romulus and Remus became one of the central foundation myths of Roman identity and political culture.",
                    "Rome",
                    "/images/events/monarchy/founding_of_rome.png",
                    "content/events/monarchy/founding-of-rome.md",
                    1L
            ),
            new Event(
                    3L,
                    "Rape of the Sabine Women",
                    -750,
                    "The Rape of the Sabine Women is a legendary event in Roman mythology, describing how Romulus and the early Romans abducted women from the neighboring community of the Sabines to populate the newly founded city of Rome.",
                    "The Rape of the Sabine Women is a legendary event in Roman mythology, describing how Romulus and the early Romans abducted women from the neighboring community of the Sabines to populate the newly founded city of Rome.",
                    "Rome",
                    "/images/events/monarchy/rape-of-sabine-women.png",
                    "content/events/monarchy/rape-of-the-sabine-women.md",
                    1L
            ),
            new Event(
                    9L,
                    "Reigns of Numa Pompilius and Tullus Hostilius",
                    -715,
                    "Numa Pompilius establishes Rome’s religious institutions and traditions, while Tullus Hostilius expands Roman power through warfare, destroys Alba Longa, and builds the first senate house, the Curia Hostilia.",
                    "This attribute is never used.",
                    "Rome",
                    "/images/events/monarchy/numa-pompilius-tullus-hostilius.png",
                    "content/events/monarchy/reigns-of-numa-and-tullus.md",
                    1L
            ),
            new Event(
                    10L,
                    "Reign of Ancus Marcius",
                    -640,
                    "Ancus Marcius combines religious piety with military expansion, defeating neighboring peoples and strengthening Rome through new fortifications, bridges, and the port of Ostia.",
                    "This attribute is never used.",
                    "Rome",
                    "/images/events/monarchy/ancus-marcius.png",
                    "content/events/monarchy/reign-of-ancus-marcius.md",
                    1L
            ),
            new Event(
                    11L,
                    "Assassination of King Servius Tullius",
                    -535,
                    "King Servius Tullius is overthrown and murdered in a conspiracy led by his ambitious daughter Tullia and her husband Lucius Tarquinius Superbus, who seizes the Roman throne.",
                    "This attribute is never used.",
                    "Rome",
                    "/images/events/monarchy/king-servius-tullius-assassination.png",
                    "content/events/monarchy/assassination-of-king-servius-tullius.md",
                    1L
            ),
            new Event(
                    4L,
                    "Expulsion of the last king Tarquinius Superbus and the end of the Roman Monarchy",
                    -509,
                    "The Romans overthrow Tarquinius Superbus, the last king of Rome, ending the monarchy and establishing the Roman Republic after outrage over the tyranny of the Tarquin family.",
                    "The expulsion of the last Roman king, Tarquinius Superbus, traditionally marked the end of the Roman Monarchy and the beginning of the Roman Republic. This event became a foundational political memory for the Romans, who strongly associated kingship with tyranny afterward.",
                    "Rome",
                    "/images/events/monarchy/expulsion-of-tarquinius-superbus.png",
                    "content/events/monarchy/expulsion-of-last-king-tarquinius-superbus.md",
                    1L
            ),
            new Event(
                    5L,
                    "Twelve Tables",
                    -451,
                    "The first attempt to create a code of law for Rome.",
                    "The Twelve Tables were an early codification of Roman law, traditionally created in the mid-5th century BC. They were significant because they made important legal rules more visible and stable, reducing arbitrary interpretation by elites.",
                    "Rome",
                    "/images/events/republic/twelve_tables.png",
                    "content/events/republic/twelve-tables.md",
                    2L
            ),
            new Event(
                    6L,
                    "Assassination of Julius Caesar",
                    -44,
                    "Caesar was assassinated by a group of senators.",
                    "Julius Caesar was assassinated on the Ides of March in 44 BC by a group of senators who feared his growing power. The assassination did not restore the Republic as the conspirators hoped; instead, it accelerated the conflicts that led to the rise of Augustus and the Roman Empire.",
                    "Rome",
                    "/images/events/republic/assassination_julius_caesar.jpg",
                    "content/events/republic/assassination-of-julius-caesar.md",
                    2L
            ),
            new Event(
                    7L,
                    "Beginning of Augustus' Rule",
                    -27,
                    "Octavian became Augustus, marking the beginning of the Empire.",
                    "In 27 BC, Octavian received the title Augustus, a turning point traditionally seen as the beginning of the Roman Empire. Although republican institutions formally continued, political power became increasingly concentrated in the hands of the emperor.",
                    "Rome",
                    "/images/events/empire/augustus_rule.png",
                    "content/events/empire/beginning-of-the-empire.md",
                    3L
            ),
            new Event(
                    8L,
                    "Fall of the Western Roman Empire",
                    476,
                    "Romulus Augustulus was deposed, traditionally marking the fall of the Western Empire.",
                    "In AD 476, the deposition of Romulus Augustulus by Odoacer is traditionally used to mark the fall of the Western Roman Empire. Although the Eastern Roman Empire continued for many centuries, this event became a major symbolic dividing line in European history.",
                    "Ravenna",
                    "/images/events/empire/fall_roman_empire.jpg",
                    "content/events/empire/fall-of-western-empire.md",
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
