package pl.robertburek.kursspring.domain.repository;

import pl.robertburek.kursspring.domain.Knight;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;


/**
 * Created by Robert Burek
 */

public class InDBKnightRepository implements KnightRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);
        entityManager.persist(knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return entityManager.createQuery("from Knight", Knight.class).getResultList();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Knight knightByName = entityManager.createQuery("from Knight k where k.name=:name", Knight.class)
                .setParameter("name", name).getSingleResult();
        return Optional.ofNullable(knightByName);
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        Knight knight = entityManager.find(Knight.class, id);
        entityManager.remove(knight);
    }

    @Override
    public void build() {
    }

    @Override
    public void tearDown() {
    }

    @Override
    public void setName(String name) {
    }

    @Override
    @Transactional
    public void createKnight(Knight knight) {
        entityManager.persist(knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return entityManager.find(Knight.class, id);
    }

    @Override
    @Transactional
    public void updateKnight(int id, Knight knight) {
        entityManager.merge(knight);
    }

}
