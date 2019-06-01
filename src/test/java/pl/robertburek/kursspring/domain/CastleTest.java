package pl.robertburek.kursspring.domain;

import org.junit.Test;
import pl.robertburek.kursspring.domain.Castle;
import pl.robertburek.kursspring.domain.Knight;

import static org.junit.Assert.assertEquals;

/**
 * Created by Robert Burek
 */
public class CastleTest {

    @Test
    public void castleToStringMessage() {
        Quest quest = new Quest();
        Knight knight = new Knight();
        knight.setQuest(quest);
        Castle castle = new Castle(knight,"New Castle");
        String except = "Znajduje się tu zamek o nazwie New Castle. Zamieszkuje go Rycerz o imieniu Zbyszko(35). Ma " +
                "za zadanie : Uratuj wszystkie księżniczki.";
        assertEquals(except, castle.toString());

    }
}
