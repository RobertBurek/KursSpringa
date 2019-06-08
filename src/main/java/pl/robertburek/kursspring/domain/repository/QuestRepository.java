package pl.robertburek.kursspring.domain.repository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.robertburek.kursspring.domain.Quest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by Robert Burek
 */

@Repository
public class QuestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    Random rand = new Random();

//    Map<Integer, Quest> quests = new HashMap<>();


    @Transactional  //oznaczamy metodę która musi się wykonać w całości lub w ogóle
    public void createQuest(String description, Integer newReward) {
        Quest newQuest = new Quest(description, newReward);
        entityManager.persist(newQuest);
    }

    public List<Quest> getAllQuest() {
        return entityManager.createQuery("from Quest", Quest.class).getResultList();
//        return new ArrayList<>(quests.values());
    }

//    @PostConstruct
//    public void init() {
//
//    }

    @Transactional
    public void deleteQuest(Quest quest) {
        entityManager.remove(quest);
//        quests.remove(quest.getId());
    }

//    @Override
//    public String toString() {
//        return "Lista zadań {" +
//                "zadanie = " + quests +
//                '}';
//    }

    //    @Scheduled(fixedDelay = 1000) //czeka na zakończenie metody i wtedy robi jeszcze raz
//    @Scheduled(fixedDelayString ="${questCreationDelay}", initialDelay = 3000) //czeka 3s i dopiero wykonuje
    // się pierwszy raz
//    @Scheduled(fixedRate = 1000)  //wykonuje co 1s nie czekając na zakończenie metody
    @Scheduled(fixedDelayString = "${questCreationDelay}", initialDelayString = "${questPauseDelay}")
    @Transactional
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Zdobąć złoto od kapłanów.");
        descriptions.add("Zbuduj nowy zamek.");
        descriptions.add("Poślub księżniczkę.");
        descriptions.add("Rozpraw się ze zdrajcami");
        descriptions.add("Zbierz podatki od mieszkańców królestwa.");
        descriptions.add("Ratuj księżniczkę!");
        descriptions.add("Weź udział w turnieju!");
        descriptions.add("Zabij smoka!!!");
        descriptions.add("Zdobąć wojska na wojnę.");
        descriptions.add("Rozpal ognisko.");
        descriptions.add("Zbuduj wielki szałas.");
        descriptions.add("Jedź na polowanie.");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        Integer newReward = rand.nextInt(150);
        System.out.println("Utworzyłem zadania: \"" + description + "\"");
        createQuest(description, newReward);

    }

    @Transactional
    public void update(Quest quest) {
        entityManager.merge(quest);
//        quests.put(quest.getId(),quest);
    }

    public Quest getQuest(Integer id) {
        return entityManager.find(Quest.class, id);
//        return quests.get(id);
    }
}
