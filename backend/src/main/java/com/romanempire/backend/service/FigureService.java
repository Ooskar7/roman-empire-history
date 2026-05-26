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
                    "Legendary founder and first king of Rome",
                    "Legendary founder of Rome and traditionally its first king.",
                    "Romulus became a model of beginnings: founder, warrior, lawgiver, and king. Whether historical or mythical, he remained a symbol for Roman identity because his life explained why Rome imagined itself as chosen, disciplined, and born from struggle.",
                    "/images/figures/monarchy/romulus.png",
                    "content/figures/monarchy/romulus.md",
                    1L
            ),
            new Figure(
                    39L,
                    "Remus",
                    -771,
                    -753,
                    "Brother of Romulus, legendary founder and first king of Rome",
                    "Legendary brother of Romulus and co-founder of Rome.",
                    "Remus was a legendary figure in Roman mythology, known for his role in the founding of Rome alongside his brother Romulus.",
                    "/images/figures/monarchy/remus.png",
                    "content/figures/monarchy/remus.md",
                    1L
            ),
            new Figure(
                    6L,
                    "King Amulius",
                    null,
                    -754,
                    "Usurper king of Alba Longa",
                    "The legendary usurper whose actions set the Romulus and Remus story in motion.",
                    "Amulius mattered because his violence failed. The survival of the twins turned his attempt at dynastic control into the beginning of Rome foundation story. In Roman legend, tyrannical power could delay destiny, but it could not defeat it.",
                    "/images/figures/monarchy/king-amulius.png",
                    "content/figures/monarchy/king-amulius.md",
                    1L
            ),
            new Figure(
                    7L,
                    "Tullia",
                    null,
                    null,
                    "Daughter of Servius Tullius and wife of Tarquinius Superbus",
                    "A legendary royal woman remembered for ambition and complicity in the fall of Servius Tullius.",
                    "Her memory became part of the darker side of monarchy. Tullia represented ambition without pietas, the Roman virtue of proper duty to family, gods, and state. Her legend helped explain why the last Tarquin dynasty seemed polluted before the Republic was born.",
                    "/images/figures/monarchy/tullia.png",
                    "content/figures/monarchy/tullia.md",
                    1L
            ),
            new Figure(
                    8L,
                    "Tarquinius Superbus",
                    null,
                    -495,
                    "Last king of Rome",
                    "The final Roman king, remembered as a symbol of tyranny.",
                    "His expulsion gave Romans one of their strongest political memories. Even centuries later, accusations of wanting to be king carried the shadow of Tarquinius. His biography mattered less as private life than as a symbol of the tyranny the Republic claimed to reject.",
                    "/images/figures/monarchy/tarquinius-superbus.png",
                    "content/figures/monarchy/tarquinius-superbus.md",
                    1L
            ),
            new Figure(
                    9L,
                    "Lucius Quinctius Cincinnatus",
                    -519,
                    -430,
                    "Roman aristocrat, consul, and dictator",
                    "A Republican ideal of temporary emergency power and civic restraint.",
                    "Cincinnatus became the classic example of limited authority. In a Republic that feared kingship but sometimes needed extraordinary command, his life showed how emergency power could be imagined as compatible with liberty.",
                    "/images/figures/republic/lucius-quinctius-cincinnatus.png",
                    "content/figures/republic/lucius-quinctius-cincinnatus.md",
                    2L
            ),
            new Figure(
                    10L,
                    "Brennus",
                    null,
                    null,
                    "Leader of the Senones Gauls",
                    "The Gallic leader associated with the sack of Rome.",
                    "For Rome, Brennus became a memory of vulnerability. His life as a historical person is obscure, but his role in Roman culture was immense: he embodied the lesson that Rome had to become stronger, better defended, and unwilling to suffer such humiliation again.",
                    "/images/figures/republic/brennus.png",
                    "content/figures/republic/brennus.md",
                    2L
            ),
            new Figure(
                    11L,
                    "Pyrrhus of Epirus",
                    -319,
                    -272,
                    "Hellenistic king and military commander",
                    "A brilliant Greek king whose costly victories against Rome became legendary.",
                    "His name survives through the phrase Pyrrhic victory, a success so costly that it weakens the victor. For Roman history, Pyrrhus was the first great Hellenistic monarch Rome endured and outlasted, proving the Republic ability to survive tactical defeat.",
                    "/images/figures/republic/pyrrhus-of-epirus.png",
                    "content/figures/republic/pyrrhus-of-epirus.md",
                    2L
            ),
            new Figure(
                    12L,
                    "Hamilcar Barca",
                    -275,
                    -228,
                    "Carthaginian general and father of Hannibal",
                    "A Barcid commander who rebuilt Carthaginian power after the First Punic War.",
                    "His Spanish campaigns laid the foundation for the Second Punic War. Hamilcar did not invade Italy himself, but his strategy, family network, and military rebuilding made Hannibal career possible. He stands at the origin of the Barcid challenge to Rome.",
                    "/images/figures/republic/hamilcar-barca.png",
                    "content/figures/republic/hamilcar-barca.md",
                    2L
            ),
            new Figure(
                    13L,
                    "Hannibal Barca",
                    -247,
                    -183,
                    "Carthaginian general",
                    "Rome greatest enemy and one of antiquity most famous commanders.",
                    "Although Carthage lost the war, Hannibal remained a model of generalship. His life forced Rome to become more adaptive and more imperial. He is remembered not simply for invading Italy, but for revealing how close Rome could come to defeat.",
                    "/images/figures/republic/hannibal-barca.png",
                    "content/figures/republic/hannibal-barca.md",
                    2L
            ),
            new Figure(
                    14L,
                    "Publius Cornelius Scipio Africanus",
                    -236,
                    -183,
                    "Roman general and statesman",
                    "The Roman commander who defeated Hannibal at Zama.",
                    "His victory earned him the name Africanus and made him one of the Republic greatest commanders. Yet his later political difficulties showed a Roman tension: the state needed exceptional generals, but feared citizens whose glory seemed larger than the Republic.",
                    "/images/figures/republic/publius-cornelius-scipio-africanus.png",
                    "content/figures/republic/publius-cornelius-scipio-africanus.md",
                    2L
            ),
            new Figure(
                    15L,
                    "Cato the Elder",
                    -234,
                    -149,
                    "Senator, censor, and moralist",
                    "A conservative Roman senator famous for moral severity and hostility to Carthage.",
                    "Cato influenced Roman moral language for generations. He represented the belief that military success and wealth could ruin the Republic from within. His hostility to Carthage helped shape the atmosphere that led to its final destruction.",
                    "/images/figures/republic/cato-the-elder.png",
                    "content/figures/republic/cato-the-elder.md",
                    2L
            ),
            new Figure(
                    16L,
                    "Scipio Aemilianus",
                    -185,
                    -129,
                    "Roman general and statesman",
                    "The conqueror of Carthage and adopted grandson of Scipio Africanus.",
                    "Scipio Aemilianus embodied Rome mature imperial power. He destroyed an ancient rival, but his life also belonged to a Republic under stress from wealth, reform disputes, and political violence. His career shows both Roman greatness and Roman unease.",
                    "/images/figures/republic/scipio-aemilianus.png",
                    "content/figures/republic/scipio-aemilianus.md",
                    2L
            ),
            new Figure(
                    17L,
                    "Marcus Livius Drusus",
                    -124,
                    -91,
                    "Tribune and reformer",
                    "A Roman tribune whose failed reform program helped trigger the Social War.",
                    "His death helped open the Social War, because many Italian allies concluded that Rome would not grant justice voluntarily. Drusus life shows how reformers in the late Republic could become flashpoints when institutions could no longer absorb change.",
                    "/images/figures/republic/marcus-livius-drusus.png",
                    "content/figures/republic/marcus-livius-drusus.md",
                    2L
            ),
            new Figure(
                    2L,
                    "Julius Caesar",
                    -100,
                    -44,
                    "General, statesman, and dictator",
                    "A central figure in the fall of the Roman Republic.",
                    "Caesar did not create the Empire himself, but his career made the old Republic impossible to restore unchanged. His name became a title for later rulers, while his assassination showed that killing one dominant man could not solve Rome deeper political crisis.",
                    "/images/figures/republic/julius-caesar.png",
                    "content/figures/republic/julius-caesar.md",
                    2L
            ),
            new Figure(
                    3L,
                    "Cicero",
                    -106,
                    -43,
                    "Statesman, orator, and philosopher",
                    "One of the greatest Roman speakers and defenders of the Republic.",
                    "Cicero legacy rests on language as much as politics. His speeches, letters, and philosophical works shaped Latin prose and later European ideas of law, duty, and republican citizenship. His death made him a martyr of the senatorial cause.",
                    "/images/figures/republic/cicero.png",
                    "content/figures/republic/cicero.md",
                    2L
            ),
            new Figure(
                    18L,
                    "Marcus Junius Brutus",
                    -85,
                    -42,
                    "Senator and conspirator against Caesar",
                    "A leading assassin of Caesar who claimed to act for Republican liberty.",
                    "Brutus became one of history most debated assassins. To some he was a tyrannicide; to others, a betrayer. His life shows the tragedy of late Republican ideals: moral language remained powerful, but action increasingly produced more violence.",
                    "/images/figures/republic/marcus-junius-brutus.png",
                    "content/figures/republic/marcus-junius-brutus.md",
                    2L
            ),
            new Figure(
                    19L,
                    "Gaius Cassius Longinus",
                    -86,
                    -42,
                    "Senator, commander, and conspirator against Caesar",
                    "A leading organizer of the conspiracy that assassinated Julius Caesar.",
                    "Cassius matters because the assassination was not only symbolic. It required networks, planning, money, and military follow-through. His career shows how Republican resistance after Caesar depended on men who were themselves products of civil war.",
                    "/images/figures/republic/gaius-cassius-longinus.png",
                    "content/figures/republic/gaius-cassius-longinus.md",
                    2L
            ),
            new Figure(
                    20L,
                    "Mark Antony",
                    -83,
                    -30,
                    "General, triumvir, and rival of Octavian",
                    "Caesar lieutenant whose rivalry with Octavian shaped the Republic final civil wars.",
                    "Antony final defeat at Actium cleared the way for Augustus. His life marks the last aristocratic challenge to Octavian supremacy and shows how Roman politics had become a contest between personal military powers.",
                    "/images/figures/republic/mark-antony.png",
                    "content/figures/republic/mark-antony.md",
                    2L
            ),
            new Figure(
                    21L,
                    "Cleopatra VII",
                    -69,
                    -30,
                    "Queen of Egypt",
                    "The last Ptolemaic ruler of Egypt and a major figure in Roman civil war politics.",
                    "Her death ended Ptolemaic rule and made Egypt a Roman possession. Cleopatra remains important because she was not merely a figure in Roman drama; she was a queen trying to preserve her dynasty against the expanding power of Rome.",
                    "/images/figures/republic/cleopatra-vii.png",
                    "content/figures/republic/cleopatra-vii.md",
                    2L
            ),
            new Figure(
                    22L,
                    "Marcus Aemilius Lepidus",
                    -89,
                    -13,
                    "Triumvir and Roman aristocrat",
                    "The least dominant member of the Second Triumvirate.",
                    "His fall from power narrowed the struggle to Antony and Octavian. Lepidus mattered because the Triumvirate needed his name and position at first, but his career also shows how quickly prestige without force could become irrelevant in the late Republic.",
                    "/images/figures/republic/marcus-aemilius-lepidus.png",
                    "content/figures/republic/marcus-aemilius-lepidus.md",
                    2L
            ),
            new Figure(
                    4L,
                    "Octavian (Augustus)",
                    -63,
                    14,
                    "First Roman emperor",
                    "The founder of the Roman Empire and its first emperor.",
                    "He founded the imperial system that governed Rome for centuries. Augustus matters as a person because he understood Roman fears better than Caesar had: he avoided the title of king while making monarchy function through Republican forms.",
                    "/images/figures/empire/augustus.png",
                    "content/figures/empire/augustus.md",
                    3L
            ),
            new Figure(
                    23L,
                    "Jesus of Nazareth",
                    -4,
                    30,
                    "Jewish teacher and central figure of Christianity",
                    "A Jewish preacher whose followers proclaimed him Messiah and Son of God.",
                    "His followers proclaimed his resurrection and built communities that spread through the Roman world. Jesus importance to Roman history lies in the fact that a provincial Jewish teacher became the center of a movement that eventually transformed the empire religious identity.",
                    "/images/figures/empire/jesus-of-nazareth.png",
                    "content/figures/empire/jesus-of-nazareth.md",
                    3L
            ),
            new Figure(
                    24L,
                    "Pontius Pilate",
                    null,
                    null,
                    "Roman governor of Judea",
                    "The Roman prefect who authorized the crucifixion of Jesus.",
                    "His fame comes from one decision: authorizing crucifixion. Pilate shows how ordinary Roman administration could become historically enormous when imperial law, local conflict, and religious memory intersected.",
                    "/images/figures/empire/pontius-pilate.png",
                    "content/figures/empire/pontius-pilate.md",
                    3L
            ),
            new Figure(
                    25L,
                    "Nero",
                    37,
                    68,
                    "Roman emperor",
                    "A Julio-Claudian emperor remembered for spectacle, suspicion, and tyranny.",
                    "Nero death ended the Julio-Claudian line and led to civil war in 69 AD. He became one of the great negative examples of Roman monarchy: an emperor whose personal desires seemed to overwhelm duty to the state.",
                    "/images/figures/empire/nero.png",
                    "content/figures/empire/nero.md",
                    3L
            ),
            new Figure(
                    26L,
                    "Vespasian",
                    9,
                    79,
                    "Roman emperor and founder of the Flavian dynasty",
                    "A soldier-emperor who restored stability after civil war.",
                    "Vespasian founded the Flavian dynasty and restored imperial finances and authority. His reign showed that emperors no longer had to come from the old ruling family. Military success and broad support could create a new imperial house.",
                    "/images/figures/empire/vespasian.png",
                    "content/figures/empire/vespasian.md",
                    3L
            ),
            new Figure(
                    27L,
                    "Titus",
                    39,
                    81,
                    "Roman emperor and Flavian commander",
                    "Vespasian son, conqueror of Jerusalem, and later emperor.",
                    "Titus strengthened Flavian legitimacy by combining military victory with an image of humane rule. His early death left a reputation shaped by promise and brevity: a ruler remembered less for long policy than for the impression of better government.",
                    "/images/figures/empire/titus.png",
                    "content/figures/empire/titus.md",
                    3L
            ),
            new Figure(
                    28L,
                    "Nerva",
                    30,
                    98,
                    "Roman emperor",
                    "The elderly senator who began the adoptive succession of the Five Good Emperors.",
                    "Nerva opened the sequence later called the Five Good Emperors. His reign showed that imperial stability could depend on choosing a capable successor rather than relying only on bloodline.",
                    "/images/figures/empire/nerva.png",
                    "content/figures/empire/nerva.md",
                    3L
            ),
            new Figure(
                    29L,
                    "Trajan",
                    53,
                    117,
                    "Roman emperor",
                    "A soldier-emperor under whom Rome reached its greatest territorial extent.",
                    "His reign represented the expansionist high point of the empire. Trajan legacy joined conquest, infrastructure, and the image of the optimus princeps, the best ruler, a standard later emperors were measured against.",
                    "/images/figures/empire/trajan.png",
                    "content/figures/empire/trajan.md",
                    3L
            ),
            new Figure(
                    30L,
                    "Hadrian",
                    76,
                    138,
                    "Roman emperor",
                    "An emperor of consolidation, travel, architecture, and frontier defense.",
                    "Hadrian helped define the empire as a governed space with defensible borders. His reign showed that imperial greatness could mean organization and cultural patronage rather than constant conquest.",
                    "/images/figures/empire/hadrian.png",
                    "content/figures/empire/hadrian.md",
                    3L
            ),
            new Figure(
                    31L,
                    "Antoninus Pius",
                    86,
                    161,
                    "Roman emperor",
                    "A long-ruling emperor associated with stability and careful administration.",
                    "His reign represented the quiet confidence of the high empire. Antoninus Pius matters because stability itself was an achievement: he preserved the system he inherited and passed power to Marcus Aurelius in good order.",
                    "/images/figures/empire/antoninus-pius.png",
                    "content/figures/empire/antoninus-pius.md",
                    3L
            ),
            new Figure(
                    32L,
                    "Marcus Aurelius",
                    121,
                    180,
                    "Roman emperor and Stoic philosopher",
                    "The philosopher-emperor whose reign faced war and plague.",
                    "Marcus Aurelius became the ideal philosopher-emperor, but his reign also marked the end of the high imperial calm. His life shows the tension between Stoic inwardness and the violent responsibilities of ruling a vast empire.",
                    "/images/figures/empire/marcus-aurelius.png",
                    "content/figures/empire/marcus-aurelius.md",
                    3L
            ),
            new Figure(
                    33L,
                    "Diocletian",
                    244,
                    311,
                    "Roman emperor and reformer",
                    "The emperor who created the Tetrarchy and rebuilt late Roman government.",
                    "His reforms stabilized Rome after decades of crisis and shaped late antiquity. Even though the Tetrarchy eventually failed, Diocletian changed how imperial power worked and prepared the conditions for later East-West division.",
                    "/images/figures/empire/diocletian.png",
                    "content/figures/empire/diocletian.md",
                    3L
            ),
            new Figure(
                    5L,
                    "Constantine the Great",
                    272,
                    337,
                    "Roman emperor",
                    "A major emperor associated with Christianity and imperial transformation.",
                    "His reign redirected Roman history. Constantine did not simply legalize a religion; he changed the relationship between emperor, church, army, and capital. His choices shaped the Christian Roman and Byzantine worlds.",
                    "/images/figures/empire/constantine-the-great.png",
                    "content/figures/empire/constantine-the-great.md",
                    3L
            ),
            new Figure(
                    34L,
                    "Theodosius I",
                    347,
                    395,
                    "Roman emperor",
                    "The emperor who made Nicene Christianity central to imperial identity.",
                    "He helped make Christianity a defining feature of Roman imperial identity. After his death, permanent division between eastern and western courts became more significant, making his reign a major turning point.",
                    "/images/figures/empire/theodosius-I.png",
                    "content/figures/empire/theodosius-I.md",
                    3L
            ),
            new Figure(
                    35L,
                    "Alaric",
                    370,
                    410,
                    "Leader of the Visigoths",
                    "The Gothic leader who sacked Rome in 410 AD.",
                    "His sack of Rome shocked contemporaries because of what the city symbolized. Alaric life reveals the late empire problem: groups Rome needed as soldiers could become enemies when honor, payment, and settlement failed.",
                    "/images/figures/empire/alaric.png",
                    "content/figures/empire/alaric.md",
                    3L
            ),
            new Figure(
                    36L,
                    "Augustine of Hippo",
                    354,
                    430,
                    "Bishop, theologian, and writer",
                    "A major Christian thinker who interpreted Rome crisis in theological terms.",
                    "He shaped Western Christianity for centuries. In Roman history, Augustine matters because he helped Christians understand the empire not as an eternal guarantee, but as one temporary human order beneath a larger spiritual horizon.",
                    "/images/figures/empire/augustine-of-hippo.png",
                    "content/figures/empire/augustine-of-hippo.md",
                    3L
            ),
            new Figure(
                    37L,
                    "Odoacer",
                    433,
                    493,
                    "Germanic military leader and king of Italy",
                    "The commander who deposed Romulus Augustulus in 476 AD.",
                    "His career marks the disappearance of the western imperial office in Italy. Odoacer did not end Roman civilization, but he showed that real power had moved from emperors to military kings operating inside Roman structures.",
                    "/images/figures/empire/odoacer.png",
                    "content/figures/empire/odoacer.md",
                    3L
            ),
            new Figure(
                    38L,
                    "Romulus Augustulus",
                    461,
                    null,
                    "Last western Roman emperor",
                    "The young emperor deposed by Odoacer in 476 AD.",
                    "His deposition became the traditional date for the fall of the Western Roman Empire. His life reminds us that historical turning points can center on people with little personal power, because institutions around them have already collapsed.",
                    "/images/figures/empire/romulus-augustulus.png",
                    "content/figures/empire/romulus-augustulus.md",
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
