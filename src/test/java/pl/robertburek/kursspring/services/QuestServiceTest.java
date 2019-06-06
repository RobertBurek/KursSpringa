package pl.robertburek.kursspring.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.robertburek.kursspring.domain.Quest;
import pl.robertburek.kursspring.domain.repository.QuestRepository;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Robert Burek
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestServiceTest {

    @Mock
    QuestRepository questRepositoryMock;

    @Test
    public void returnsNotStartedQuests() {

        List<Quest> questList = new ArrayList<>();
        Quest q1 = new Quest(1,"Test quest 1");
        Quest q2 = new Quest(2,"Test quest 2");
        Quest q3 = new Quest(3,"Test quest 3");

        q2.setStarted(true);

        questList.add(q1);
        questList.add(q2);
        questList.add(q3);

        when(questRepositoryMock.getAllQuest()).thenReturn(questList);
        QuestService qs = new QuestService();

        qs.setQuestRepository((questRepositoryMock));
        List<Quest> allNotStartedQuests =qs.getAllNotStartedQuests();

        assertEquals("Size of returned quest",2, allNotStartedQuests.size());
        assertThat(allNotStartedQuests, containsInAnyOrder(q1,q3));

    }
}