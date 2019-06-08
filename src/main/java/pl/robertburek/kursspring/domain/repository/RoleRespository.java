package pl.robertburek.kursspring.domain.repository;

import org.springframework.stereotype.Repository;
import pl.robertburek.kursspring.utils.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Robert Burek
 */

@Repository
public class RoleRespository {

    @PersistenceContext
    EntityManager entityManager;

    public void persistRole(Role role) {
        entityManager.persist(role);
    }
}
