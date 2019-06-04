package pl.robertburek.kursspring.domain.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import pl.robertburek.kursspring.domain.Knight;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robert Burek
 */


@PropertySource("classpath:inMemoryKnightRepository.properties")
public class InMemoryKnightRepository implements KnightRepository {


    @Value("${my.castle.name:Default Castle}")
    private String name;

    Map<String, Knight> knights = new HashMap<String, Knight>();

    public InMemoryKnightRepository() {
    }

    InMemoryKnightRepository(String name) {
        this.name = name;
    }

    @Override
    public void createKnight(String name, int age) {
        knights.put(name, new Knight(name, age));
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Knight getKnight(String name) {
        return knights.get(name);
    }

    @Override
    public void deleteKnight(String name) {
        knights.remove(name);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Robert", 49);
        createKnight("Grzegorz", 48);
        createKnight("Zbyszko", 52);
    }

    @Override
    @PreDestroy
    public void tearDown() {
        System.out.println("Wyburzam zamek : " + this.name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void createKnight(Knight knight) {
        knights.put(knight.getName(),knight);
    }

    @Override
    public String toString() {
        return "Lista rycerzy {" +
                "rycerz = " + knights +
                '}';
    }
}
