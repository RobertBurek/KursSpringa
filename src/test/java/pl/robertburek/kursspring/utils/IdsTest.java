package pl.robertburek.kursspring.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.robertburek.kursspring.domain.repository.InMemoryKnightRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Robert Burek
 */
public class IdsTest {

    private InMemoryKnightRepository inMemoryKnightRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testEmptySet() {
        int result = Ids.generateNewId(Collections.emptySet());
        assertEquals(0,result);
    }

    @Test
    public void testGenerateNewId(){
        Set<Integer> sample = new HashSet<>();
        sample.add(0);
        sample.add(1);
        sample.add(2);
        int result = Ids.generateNewId(sample);
        assertEquals(3,result);
    }

    @Test
    public void testGenerateNewIdWhenDeleteId(){
        Set<Integer> sample = new HashSet<>();
        sample.add(0);
        sample.add(1);
        sample.add(4);
        sample.add(6);
        int result = Ids.generateNewId(sample);
        assertEquals(7,result);
    }
}