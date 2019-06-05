package pl.robertburek.kursspring.domain.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import pl.robertburek.kursspring.domain.Knight;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Robert Burek
 */


@PropertySource("classpath:inMemoryKnightRepository.properties")
public class InMemoryKnightRepository implements KnightRepository {


    @Value("${my.castle.name:Default Castle}")
    private String name;

    Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryKnightRepository() {
    }

    InMemoryKnightRepository(String name) {
        this.name = name;
    }

    @Override
    public void createKnight(String name, int age) {
        Knight newKnight = new Knight(name, age);
        newKnight.setId(getNewId());
        knights.put(getNewId(), newKnight);
        System.out.println(newKnight);
    }

    private int getNewId() {
        if (knights.isEmpty()) {
            return 0;
        } else {
            Integer newId = knights.size() - 1;//knights.keySet().stream().max(Integer::max).get();
            return newId + 1;
        }
    }


    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Optional<Knight> knightByName = knights.values().stream()
                .filter(knight -> knight.getName().equals(name)).findAny();
        return knightByName;
        // nie powinno się tak robić - returne knoghts.get(knightByName.orElseGet(null));
        // powinno się zwrócić Optionala - zmiana w interfejsie i tak też zrobimy
    }

    @Override
    public void deleteKnight(Integer id) {
        System.out.println("Usuwam rycerza id= " + id);
        knights.remove(id);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Robert", 49);
        createKnight("Grzegorz", 48);
        createKnight("Zbyszko", 52);
        createKnight("Lancelot", 38);
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
        knight.setId(getNewId());
        knight.setLevel(0);
        knights.put(knight.getId(), knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }

    @Override
    public String toString() {
        return "Lista rycerzy {" +
                "rycerz = " + knights +
                '}';
    }
}
