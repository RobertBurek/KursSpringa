package pl.robertburek.kursspring.domain.repository;

import pl.robertburek.kursspring.domain.Knight;

import java.util.Collection;
import java.util.Optional;


/**
 * Created by Robert Burek
 */

public class InDBKnightRepository implements KnightRepository {
    @Override
    public void createKnight(String name, int age) {
//        knights.put(name, new Knight(name, age));
        System.out.println("używam bazy danych");
    }

    @Override
    public Collection<Knight> getAllKnights() {
//        return knights.values();
        System.out.println("używam bazy danych");
//        throw new NotImplementedException();
        return null;
    }

    @Override
    public Optional<Knight> getKnight(String name) {
//        return knights.get(name);
        System.out.println("używam bazy danych");
//        throw new NotImplementedException();
        return null;
    }

    @Override
    public void deleteKnight(Integer id) {
        System.out.println("używam bazy danych");
    }

    @Override

    public void build() {
//        createKnight("Robert", 49);
//        createKnight("Grzegorz", 48);
//        createKnight("Zbyszko", 52);
    }

    @Override
    public void tearDown() {
        System.out.println("używam bazy danych");
    }

    @Override
    public void setName(String name) {
        System.out.println("używam bazy danych");
    }

    @Override
    public void createKnight(Knight knight) {
        System.out.println("używam bazy danych");
    }

    @Override
    public Knight getKnightById(Integer id) {
        System.out.println("używam bazy danych");
        return null;
    }


}
