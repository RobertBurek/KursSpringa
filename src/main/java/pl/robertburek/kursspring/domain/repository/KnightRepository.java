package pl.robertburek.kursspring.domain.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import pl.robertburek.kursspring.domain.Knight;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robert Burek
 */

@Repository
@PropertySource("classpath:knightRepository.properties")
public class KnightRepository {


    @Value("${my.castle.name:Default Castle}")
    private String name;

    Map<String, Knight> knights = new HashMap<String, Knight>();

    public KnightRepository() {
    }

    KnightRepository(String name) {
        this.name = name;
    }

    public void createKnight(String name, int age) {
        knights.put(name, new Knight(name, age));
    }

    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    public Knight getKnight(String name) {
        return knights.get(name);
    }

    public void deleteKnight(String name) {
        knights.remove(name);
    }

    @PostConstruct
    public void build() {
        createKnight("Robert", 49);
        createKnight("Grzegorz", 48);
        createKnight("Zbyszko", 52);
    }

    @PreDestroy
    public void tearDown() {
        System.out.println("Wyburzam zamek : " + this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lista rycerzy {" +
                "rycerz = " + knights +
                '}';
    }
}
