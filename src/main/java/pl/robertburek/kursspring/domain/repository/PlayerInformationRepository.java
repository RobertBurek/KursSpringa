package pl.robertburek.kursspring.domain.repository;

import org.springframework.stereotype.Repository;
import pl.robertburek.kursspring.domain.PlayerInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Robert Burek
 */
@Repository
public class PlayerInformationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createPlayerInformation(PlayerInformation playerInformation) {
        PlayerInformation playerInfo = new PlayerInformation();
        entityManager.persist(playerInfo);
    }

    public PlayerInformation getFirst() {
        return entityManager.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }
}
