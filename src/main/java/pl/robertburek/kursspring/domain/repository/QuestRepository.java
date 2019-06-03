package pl.robertburek.kursspring.domain.repository;

import org.springframework.stereotype.Repository;
import pl.robertburek.kursspring.domain.Quest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert Burek
 */

@Repository
public class QuestRepository {

    List<Quest> questList = new ArrayList<>();

    public void createQuest(String description) {
        questList.add(new Quest(description));
    }

    public List<Quest> getAllQuest() {
        return questList;
    }

    @PostConstruct
    public void init() {
        createQuest("Ratuj księżniczkę!");
        createQuest("Weż udział w turnieju!");
        createQuest("Zabij smoka!!!");
        createQuest("Zdobąć wojska na wojnę.");
        createQuest("Rozpal ognisko.");
        createQuest("Zbuduj wielki szałas.");
    }

    public void deleteQuest(Quest quest) {
        questList.remove(quest);
    }

    @Override
    public String toString() {
        return "Lista zadań {" +
                "zadanie = " + questList +
                '}';
    }
}
