package pl.robertburek.kursspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.robertburek.kursspring.domain.Quest;
import pl.robertburek.kursspring.domain.repository.InMemoryKnightRepository;
import pl.robertburek.kursspring.domain.repository.KnightRepository;
import pl.robertburek.kursspring.domain.repository.QuestRepository;

import java.util.List;
import java.util.Random;

/**
 * Created by Robert Burek
 */

@Component
public class QuestService {

    @Autowired
//    @Qualifier("inMemoryKnightRepository")
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random rand = new Random();

    public void assignRandomQuest(String knightName) {
        List<Quest> allQuests = questRepository.getAllQuest();
        Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
        questRepository.deleteQuest(randomQuest);
    }

}
