package bcntec.spring.data.a_jpa_dao;

import bcntec.spring.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class UserDAO extends AbstractDAO<UserEntity, Long> {


    @Autowired
    public UserDAO(EntityManager entityManager) {
        super(UserEntity.class, entityManager);
    }


    public List<UserEntity> listOrderByName() {
        return getEntityManager().createNamedQuery("userOrderByName", UserEntity.class)
                .getResultList();
    }

/*
    public BigDecimal debt(){
        return getEntityManager()
                .createNativeQuery("select sum(d.debt) from USERS u, ACCOUNTS d where u.id=d.id")
                .getSingleResult();
    }

 */
}
