package bcntec.spring.data.test.entityManager;

import bcntec.spring.data.a_jpa_dao.UserDAO;
import bcntec.spring.data.entities.UserEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class EntityDAOTest {
    private static final Logger log = LoggerFactory.getLogger(EntityDAOTest.class);


    @Test
    public void dao() {
        Map<String, String> map = new HashMap<>();
        map.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        map.put("hibernate.hbm2ddl.auto", "create");
        map.put("hibernate.show", "true");
        map.put("javax.persistence.jdbc.url", "jdbc:hsqldb:mem:jpa21:persistence-unit");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:persistence-unit", map);
        EntityManager entityManager = factory.createEntityManager();

        UserDAO userDAO = new UserDAO(entityManager);

        for (UserEntity user : userDAO.listOrderByName()) {
            log.info(user.getName());
        }

        UserEntity juan = userDAO.findById(1L);

        System.out.println(juan);

    }

}
