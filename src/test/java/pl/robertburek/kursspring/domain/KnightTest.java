package pl.robertburek.kursspring.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Robert Burek
 */
public class KnightTest {

    @Test
    public void testIfQuestMarkedAsStarted() {
        Knight knight=new Knight("TestowyRycerz",25);
        Quest quest =new Quest(1,"Teskowe zadanie");
        knight.setQuest(quest);
        assertTrue(knight.getQuest().isStarted());
    }
}