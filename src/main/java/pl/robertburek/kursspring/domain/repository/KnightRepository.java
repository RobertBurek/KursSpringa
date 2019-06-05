package pl.robertburek.kursspring.domain.repository;

import pl.robertburek.kursspring.domain.Knight;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Robert Burek
 */
public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    void build();

    void tearDown();

    void setName(String name);

    void createKnight(Knight knight);

    Knight getKnightById(Integer id);
}
