package pl.robertburek.kursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.robertburek.kursspring.domain.PlayerInformation;
import pl.robertburek.kursspring.domain.repository.KnightRepository;
import pl.robertburek.kursspring.domain.repository.PlayerInformationRepository;
import pl.robertburek.kursspring.domain.repository.QuestRepository;
import pl.robertburek.kursspring.domain.repository.RoleRespository;
import pl.robertburek.kursspring.services.QuestService;
import pl.robertburek.kursspring.utils.Role;

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

    @Autowired
    RoleRespository roleRespository;

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

        PlayerInformation playerInformation= new PlayerInformation();
        playerInformationRepository.createPlayerInformation(playerInformation);

        PlayerInformation playerInformation1 = new PlayerInformation("Robert", "Robert");
        playerInformationRepository.createPlayerInformation(playerInformation1);
        PlayerInformation playerInformation2 = new PlayerInformation("user1", "");
        playerInformationRepository.createPlayerInformation(playerInformation2);

        Role RobertRoleUSER = new Role("Robert", "USER");
        Role RobertRoleADMIN = new Role("Robert", "ADMIN");
        Role user1RoleUSER = new Role("user1", "USER");

        roleRespository.persistRole(RobertRoleUSER);
        roleRespository.persistRole(RobertRoleADMIN);
        roleRespository.persistRole(user1RoleUSER);

        questService.assignRandomQuest("Robert");
        questService.assignRandomQuest("Grzegorz");
//        questService.assignRandomQuest("Zbyszko");
    }
}
