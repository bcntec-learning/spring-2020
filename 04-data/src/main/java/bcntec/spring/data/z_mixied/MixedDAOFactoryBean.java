package bcntec.spring.data.z_mixied;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static org.springframework.data.querydsl.QuerydslUtils.QUERY_DSL_PRESENT;

public class MixedDAOFactoryBean<R extends MixedDAO<T, ID>, T, ID extends Serializable>
        extends JpaRepositoryFactoryBean<R, T, ID> {

    public MixedDAOFactoryBean(Class<? extends R> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
        return new GenericDAOFactory(em);
    }

    private static class GenericDAOFactory<T, ID extends Serializable>
            extends JpaRepositoryFactory {

        private final EntityManager entityManager;

        public GenericDAOFactory(EntityManager entityManager) {
            super(entityManager);
            this.entityManager = entityManager;
        }


        @Override
        protected JpaRepositoryImplementation<T, ID> getTargetRepository(RepositoryInformation metadata, EntityManager entityManager) {
            MixedDAOImpl<T, ID> repository = new MixedDAOImpl<>((Class<T>) metadata.getDomainType(), getEntityManager());
            //repository.setRepositoryMethodMetadata(crudMethodMetadataPostProcessor.getCrudMethodMetadata());
            return repository;
        }

        boolean isQueryDslExecutor(Class<?> repositoryInterface) {

            return QUERY_DSL_PRESENT && QuerydslPredicateExecutor.class.isAssignableFrom(repositoryInterface);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            if (isQueryDslExecutor(metadata.getRepositoryInterface())) {
                return QuerydslJpaRepository.class;
            } else {
                return MixedDAOImpl.class;
            }
        }

        public EntityManager getEntityManager() {
            return entityManager;
        }
    }
}