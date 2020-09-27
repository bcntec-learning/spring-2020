package bcntec.spring.data.a_jpa_dao;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class AbstractDAO<E, ID> {
    private final Class<E> entityClazz;
    private final EntityManager entityManager;


    public AbstractDAO(Class<E> entityClazz, EntityManager entityManager) {
        this.entityClazz = entityClazz;
        this.entityManager = entityManager;
    }

    public E findById(ID id) {
        try {
            return entityManager.find(entityClazz, id);
        } catch (NoResultException e) {
            return null;
        }
    }

    public E persist(E e) {
        getEntityManager().persist(e);
        //entityManager.flush();
        //entityManager.merge(e);
        return e;
    }

    public List<E> listAll() {
        return getEntityManager().createQuery(
                "from " + getEntityClazz().getSimpleName().replace("Entity", ""),
                getEntityClazz()).getResultList();


    }

    public E deleteById(ID id) {
        E d = findById(id);
        if (d != null) {
            getEntityManager().remove(d);
        }
        return d;
    }

    public Class<E> getEntityClazz() {
        return entityClazz;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
