package pl.robertburek.kursspring.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Robert Burek
 */
public class QuestTest {

    @Test
    public void settingStartedFlagToFalseShouldSetStartDate() {
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);
        assertNotNull(quest.startDate);
    }

    @Test
    public void questShouldBeCompleted() {
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);
        quest.lenghtInSeconds = -60;
        assertTrue(quest.isCompleted());
        assertTrue(quest.isCompleted());   //ze względu na isAfter
    }

    @Test
    public void questShouldNotBeCompleted() {
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);
        quest.lenghtInSeconds = 2000;
        assertFalse(quest.isCompleted());
        assertFalse(quest.isCompleted());  //ze względu na isAfter
    }
}