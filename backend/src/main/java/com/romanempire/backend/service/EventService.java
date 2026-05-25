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
                    12L,
                    "Rome Defeats the Clusians and Sabines",
                    -508,
                    "Rome defends the young Republic against Clusian and Sabine pressure while Publius Valerius Publicola limits concentrated authority.",
                    "In the first years after the monarchy, Rome fought enemies connected with the old royal order and neighboring Sabine rivals. Roman tradition remembered these struggles as proof that the Republic could survive war while leaders such as Publicola devolved some powers to quaestors and accepted limits on magistrates.",
                    "Rome",
                    "/images/events/republic/clusians-and-sabines.png",
                    "content/events/republic/clusians-and-sabines.md",
                    2L
            ),
            new Event(
                    13L,
                    "Secessio Plebis and the Conflict of the Orders",
                    -494,
                    "The plebeians withdraw from Rome, forcing recognition of their political voice and beginning the Conflict of the Orders.",
                    "The first Secessio Plebis was a collective withdrawal by Rome's common citizens during a crisis over debt, military service, and political exclusion. The settlement created tribunes of the plebs and began the long Conflict of the Orders between patrician privilege and plebeian rights.",
                    "Sacred Mount",
                    "/images/events/republic/secessio-plebis.png",
                    "content/events/republic/secessio-plebis.md",
                    2L
            ),
            new Event(
                    14L,
                    "Reform, Crisis, and the Dictatorships of Cincinnatus",
                    -471,
                    "The Republic moves between reform and emergency rule, including plebeian gains and the legendary dictatorships of Cincinnatus.",
                    "Between 471 and 439 BC, Rome experienced political reform, legal pressure, and moments of authoritarian emergency. The traditions surrounding Cincinnatus made him a model of temporary power used for the Republic and then surrendered.",
                    "Rome",
                    "/images/events/republic/liberalization-and-cincinnatus.png",
                    "content/events/republic/liberalization-and-cincinnatus.md",
                    2L
            ),
            new Event(
                    5L,
                    "Twelve Tables",
                    -450,
                    "The first attempt to create a code of law for Rome.",
                    "The Twelve Tables were an early codification of Roman law, traditionally created in the mid-5th century BC. They were significant because they made important legal rules more visible and stable, reducing arbitrary interpretation by elites.",
                    "Rome",
                    "/images/events/republic/twelve-tables.png",
                    "content/events/republic/twelve-tables.md",
                    2L
            ),
            new Event(
                    15L,
                    "The Senones Gauls Sack Rome",
                    -390,
                    "The Senones defeat Rome at the Allia and sack the city, creating one of Rome's deepest memories of vulnerability.",
                    "The Gallic sack of Rome in 390 BC became a traumatic symbol of danger and resilience. After defeat at the Allia, the city was plundered, and later Romans remembered the crisis as a warning that military discipline and defensive strength were essential.",
                    "Rome",
                    "/images/events/republic/sack-of-rome-by-senones.png",
                    "content/events/republic/sack-of-rome-by-senones.md",
                    2L
            ),
            new Event(
                    16L,
                    "The Pyrrhic War and Expansion into Greek Lands",
                    -280,
                    "Rome fights King Pyrrhus at Heraclea, Asculum, and Tarentum while expanding into Greek-speaking southern Italy.",
                    "The Pyrrhic War brought Rome into direct conflict with a Hellenistic king and the Greek cities of southern Italy. Although Pyrrhus won costly battlefield victories, Rome's endurance forced Tarentum to submit and made Rome a major Mediterranean power.",
                    "Southern Italy",
                    "/images/events/republic/pyrrhic-war.png",
                    "content/events/republic/pyrrhic-war.md",
                    2L
            ),
            new Event(
                    17L,
                    "First Punic War",
                    -264,
                    "Rome defeats Carthage in a long naval war and gains its first overseas provinces.",
                    "The First Punic War began over Sicily and forced Rome to become a naval power. Victory over Carthage gave Rome Sicily and later Sardinia and Corsica, transforming the Republic into an overseas imperial state.",
                    "Sicily",
                    "/images/events/republic/first-punic-war.png",
                    "content/events/republic/first-punic-war.md",
                    2L
            ),
            new Event(
                    18L,
                    "Second Punic War and Hannibal's Invasion",
                    -218,
                    "Hannibal invades Italy, wins famous victories, and nearly breaks Roman power before Rome defeats Carthage.",
                    "The Second Punic War tested Rome more severely than any earlier conflict. Hannibal's victories at Trebia, Trasimene, and Cannae devastated Roman armies, but Rome endured and ultimately defeated Carthage at Zama.",
                    "Italy",
                    "/images/events/republic/second-punic-war.png",
                    "content/events/republic/second-punic-war.md",
                    2L
            ),
            new Event(
                    19L,
                    "Third Punic War and the Destruction of Carthage",
                    -146,
                    "Rome destroys Carthage and turns its territory into the province of Africa.",
                    "The Third Punic War ended Rome's rivalry with Carthage. After a brutal siege, Scipio Aemilianus captured and destroyed the city in 146 BC, confirming Roman dominance in the western Mediterranean.",
                    "Carthage",
                    "/images/events/republic/third-punic-war.png",
                    "content/events/republic/third-punic-war.md",
                    2L
            ),
            new Event(
                    20L,
                    "Social War Uprisings",
                    -91,
                    "Rome's Italian allies rebel to demand citizenship after generations of military service without equal rights.",
                    "The Social War was a revolt by Rome's Italian allies over citizenship and political inclusion. Rome defeated the uprising partly by granting citizenship, reshaping Italy and accelerating the Republic's internal transformation.",
                    "Italy",
                    "/images/events/republic/social-war.png",
                    "content/events/republic/social-war.md",
                    2L
            ),
            new Event(
                    6L,
                    "Assassination of Julius Caesar",
                    -44,
                    "Julius Caesar is killed on the Ides of March by senators who fear that his dictatorship has ended Republican liberty.",
                    "Julius Caesar was assassinated on 15 March 44 BC by conspirators including Brutus and Cassius. The murder was meant to save the Republic, but it instead unleashed renewed civil war and accelerated the rise of Augustus.",
                    "Rome",
                    "/images/events/republic/assassination-of-julius-caesar.png",
                    "content/events/republic/assassination-of-julius-caesar.md",
                    2L
            ),
            new Event(
                    21L,
                    "Roman Civil Wars and the Fall of the Republic",
                    -43,
                    "The Second Triumvirate, proscriptions, Philippi, and Actium leave Octavian as sole master of the Roman world.",
                    "From 43 to 30 BC, Rome moved through proscriptions, the defeat of Caesar's assassins, rivalry between Antony and Octavian, and the final victory at Actium. The Republic's institutions survived in name, but power passed to Octavian.",
                    "Roman Mediterranean",
                    "/images/events/republic/fall-of-the-republic.png",
                    "content/events/republic/fall-of-the-republic.md",
                    2L
            ),
            new Event(
                    7L,
                    "Octavian Becomes Augustus and Begins the Pax Romana",
                    -27,
                    "Octavian receives the title Augustus, creating imperial rule behind restored Republican forms.",
                    "In 27 BC, Octavian received the title Augustus and built the Principate, a system that preserved Republican language while concentrating power in the emperor. His settlement began the Roman Empire and the long stability later known as the Pax Romana.",
                    "Rome",
                    "/images/events/empire/beginning-of-the-empire.png",
                    "content/events/empire/beginning-of-the-empire.md",
                    3L
            ),
            new Event(
                    22L,
                    "Crucifixion of Jesus and Beginnings of Christianity",
                    30,
                    "Jesus of Nazareth is crucified under Pontius Pilate, and his followers begin the movement that becomes Christianity.",
                    "The crucifixion of Jesus in Judea under Roman authority became the central event of early Christianity. His followers proclaimed his resurrection and formed communities that spread through the Roman world.",
                    "Jerusalem",
                    "/images/events/empire/crucifixion-and-beginnings-of-christianity.png",
                    "content/events/empire/crucifixion-and-beginnings-of-christianity.md",
                    3L
            ),
            new Event(
                    23L,
                    "The Great Fire of Rome under Nero",
                    64,
                    "A devastating fire burns much of Rome and damages Nero's reputation.",
                    "The Great Fire of 64 AD destroyed large parts of Rome. Nero organized relief and rebuilding, but rumors that he benefited from the disaster damaged his rule, and Christians were blamed and persecuted.",
                    "Rome",
                    "/images/events/empire/great-fire-of-rome.png",
                    "content/events/empire/great-fire-of-rome.md",
                    3L
            ),
            new Event(
                    24L,
                    "First Jewish Revolt",
                    66,
                    "Jewish rebels rise against Roman rule, leading to the destruction of Jerusalem and the Second Temple.",
                    "The First Jewish Revolt began in 66 AD after years of tension in Judea. Roman forces under Vespasian and Titus suppressed the revolt, captured Jerusalem, and destroyed the Second Temple in 70 AD.",
                    "Judea",
                    "/images/events/empire/first-jewish-revolt.png",
                    "content/events/empire/first-jewish-revolt.md",
                    3L
            ),
            new Event(
                    25L,
                    "The Five Good Emperors",
                    96,
                    "Nerva, Trajan, Hadrian, Antoninus Pius, and Marcus Aurelius preside over a long age of imperial stability.",
                    "From 96 to 180 AD, the reigns of the Five Good Emperors brought effective administration, controlled succession, frontier consolidation, and the high point of the Pax Romana.",
                    "Roman Empire",
                    "/images/events/empire/five-good-emperors.png",
                    "content/events/empire/five-good-emperors.md",
                    3L
            ),
            new Event(
                    26L,
                    "Diocletian and the Tetrarchy",
                    284,
                    "Diocletian divides imperial rule among four rulers to stabilize the empire after decades of crisis.",
                    "Diocletian's Tetrarchy reorganized imperial authority by assigning rule to two senior and two junior emperors. The reform stabilized the empire but also prepared the later distinction between eastern and western rule.",
                    "Roman Empire",
                    "/images/events/empire/diocletian-and-the-tetrarchy.png",
                    "content/events/empire/diocletian-and-the-tetrarchy.md",
                    3L
            ),
            new Event(
                    27L,
                    "Rise and Reign of Constantine the Great",
                    306,
                    "Constantine defeats his rivals, favors Christianity, and founds Constantinople.",
                    "Constantine the Great rose from civil war to become sole emperor. His reign transformed imperial politics, gave Christianity open support, and founded Constantinople as a new imperial capital.",
                    "Roman Empire",
                    "/images/events/empire/constantine-the-great.png",
                    "content/events/empire/constantine-the-great.md",
                    3L
            ),
            new Event(
                    28L,
                    "Edict of Milan",
                    313,
                    "Constantine and Licinius grant legal toleration to Christianity and restore confiscated property.",
                    "The Edict of Milan legalized Christianity and ended the immediate legacy of persecution. It marked the beginning of Christianity's public rise within Roman imperial institutions.",
                    "Milan",
                    "/images/events/empire/edict-of-milan.png",
                    "content/events/empire/edict-of-milan.md",
                    3L
            ),
            new Event(
                    29L,
                    "Theodosius I and Christianity as State Religion",
                    379,
                    "Theodosius I supports Nicene Christianity and makes it central to imperial identity.",
                    "Under Theodosius I, Nicene Christianity became the official faith of the empire. His reign reshaped Roman religious policy and was the last time one emperor ruled both East and West.",
                    "Roman Empire",
                    "/images/events/empire/theodosius-and-state-christianity.png",
                    "content/events/empire/theodosius-and-state-christianity.md",
                    3L
            ),
            new Event(
                    30L,
                    "The Visigoths Sack Rome",
                    410,
                    "Alaric's Visigoths enter Rome, shocking the empire and revealing the weakness of western imperial power.",
                    "The Visigothic sack of Rome in 410 AD did not end the empire, but it deeply shook Roman confidence. The event exposed western military and political weakness and became a major symbol of decline.",
                    "Rome",
                    "/images/events/empire/sack-of-rome-by-visigoths.png",
                    "content/events/empire/sack-of-rome-by-visigoths.md",
                    3L
            ),
            new Event(
                    8L,
                    "Fall of the Western Roman Empire",
                    476,
                    "Odoacer deposes Romulus Augustulus, traditionally marking the end of the Western Roman Empire.",
                    "In 476 AD, Odoacer deposed Romulus Augustulus and ended the line of western emperors in Italy. The event symbolized the collapse of centralized western imperial rule, even though Roman institutions and the Eastern Empire continued.",
                    "Ravenna",
                    "/images/events/empire/fall-of-western-empire.png",
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
