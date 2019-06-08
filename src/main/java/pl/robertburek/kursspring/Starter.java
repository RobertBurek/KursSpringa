package pl.robertburek.kursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.robertburek.kursspring.domain.PlayerInformation;
import pl.robertburek.kursspring.domain.repository.InMemoryKnightRepository;
import pl.robertburek.kursspring.domain.repository.KnightRepository;
import pl.robertburek.kursspring.domain.repository.PlayerInformationRepository;
import pl.robertburek.kursspring.domain.repository.QuestRepository;
import pl.robertburek.kursspring.services.QuestService;

import javax.transaction.Transactional;


/**
 * Created by Robert Burek
 */

@Service
@Scope("singleton")

public class Starter implements CommandLineRunner {

    @Autowired
//    @Qualifier("inDBKnightRepository") przenosimy do profilii @Profile
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Override
    @Transactional //musimy też oznaczyć tę metodę aby wykonała się metoda createQuest
    public void run(String... args) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        System.out.println(questRepository);

        knightRepository.createKnight("Robert", 49);
        knightRepository.createKnight("Grzegorz", 48);
        knightRepository.createKnight("Zbyszko", 52);
        knightRepository.createKnight("Lancelot", 38);

        playerInformationRepository.createPlayerInformation(new PlayerInformation());

        questService.assignRandomQuest("Robert");

        questService.assignRandomQuest("Grzegorz");
//        questService.assignRandomQuest("Zbyszko");
    }
}
