package bcntec.spring.data.z_mixied;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public class MixedDAOImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements MixedDAO<T, ID> {

    private final EntityManager entityManager;

    public MixedDAOImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    public MixedDAOImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager, EntityManager entityManager1) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager1;
    }

    @Transactional
    public Optional<T> findAndDeleteById(ID id) {
        T deleted = entityManager.find(this.getDomainClass(), id);
        Optional<T> returned = Optional.empty();

        if (deleted != null) {
            entityManager.remove(deleted);
            returned = Optional.of(deleted);
        }
        return returned;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<T> getDomainClass() {
        return super.getDomainClass();
    }
}