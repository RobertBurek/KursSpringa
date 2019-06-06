package pl.robertburek.kursspring.domain.repository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.robertburek.kursspring.domain.Quest;
import pl.robertburek.kursspring.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.*;


/**
 * Created by Robert Burek
 */

@Repository
public class QuestRepository {

    Random rand = new Random();

    Map<Integer, Quest> quests = new HashMap<>();


    public void createQuest(String description) {
        int newId = Ids.generateNewId(quests.keySet());
        Quest quest = new Quest(newId, description);
        quests.put(newId, quest);
    }

    public List<Quest> getAllQuest() {
        return new ArrayList<>(quests.values());
    }

    @PostConstruct
    public void init() {

    }

    public void deleteQuest(Quest quest) {
        quests.remove(quest.getId());
    }

    @Override
    public String toString() {
        return "Lista zadań {" +
                "zadanie = " + quests +
                '}';
    }

    //    @Scheduled(fixedDelay = 1000) //czeka na zakończenie metody i wtedy robi jeszcze raz
//    @Scheduled(fixedDelayString ="${questCreationDelay}", initialDelay = 3000) //czeka 3s i dopiero wykonuje
    // się pierwszy raz
//    @Scheduled(fixedRate = 1000)  //wykonuje co 1s nie czekając na zakończenie metody
    @Scheduled(fixedDelayString = "${questCreationDelay}", initialDelayString = "${questPauseDelay}")
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Zdobąć złoto od kapłanów.");
        descriptions.add("Zbuduj nowy zamek.");
        descriptions.add("Poślub księżniczkę.");
        descriptions.add("Rozpraw się ze zdrajcami");
        descriptions.add("Zbierz podatki od mieszkańców królestwa.");
        descriptions.add("Ratuj księżniczkę!");
        descriptions.add("Weż udział w turnieju!");
        descriptions.add("Zabij smoka!!!");
        descriptions.add("Zdobąć wojska na wojnę.");
        descriptions.add("Rozpal ognisko.");
        descriptions.add("Zbuduj wielki szałas.");
        descriptions.add("Jedź na polowanie.");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        System.out.println("Utworzyłem zadania: \"" + description + "\"");
        createQuest(description);

    }

    public void update(Quest quest) {
        quests.put(quest.getId(),quest);
    }

    public Quest getQuest(Integer id) {
        return quests.get(id);
    }
}
