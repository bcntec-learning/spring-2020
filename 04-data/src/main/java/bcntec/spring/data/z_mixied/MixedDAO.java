package bcntec.spring.data.z_mixied;

import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface MixedDAO<T, ID extends Serializable>
        extends MixedJPARepository<T, ID> {

    EntityManager getEntityManager();

    Class<T> getDomainClass();

    default T find(ID id) {
        return getOne(id);
    }


    @SuppressWarnings("unchecked")
    default List<T> list() {
        return getEntityManager().createQuery("from " + getDomainClass().getName()).getResultList();
    }

    default T create(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    default T update(T entity) {
        return getEntityManager().merge(entity);
    }

    default T delete(Integer id) {
        T entity = getEntityManager().find(getDomainClass(), id);
        getEntityManager().remove(entity);
        return entity;
    }

    default T getSingleResult(TypedQuery<T> query) {
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
