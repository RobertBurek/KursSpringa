package pl.robertburek.kursspring.domain.repository;

import pl.robertburek.kursspring.domain.Knight;

import java.util.Collection;

/**
 * Created by Robert Burek
 */
public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Knight getKnight(String name);

    void deleteKnight(String name);

    void build();

    void tearDown();

    void setName(String name);

    void createKnight(Knight knight);
}
