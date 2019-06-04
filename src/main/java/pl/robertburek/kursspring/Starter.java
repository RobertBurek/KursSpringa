package pl.robertburek.kursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.robertburek.kursspring.domain.repository.InMemoryKnightRepository;
import pl.robertburek.kursspring.domain.repository.KnightRepository;
import pl.robertburek.kursspring.domain.repository.QuestRepository;
import pl.robertburek.kursspring.services.QuestService;


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


    @Override
    public void run(String... args) throws Exception {
//        System.out.println(questRepository);
//        System.out.println(knightRepository);


        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        System.out.println(questRepository);

        questService.assignRandomQuest("Robert");
        questService.assignRandomQuest("Grzegorz");
        questService.assignRandomQuest("Zbyszko");
        System.out.println(knightRepository);
    }
}
