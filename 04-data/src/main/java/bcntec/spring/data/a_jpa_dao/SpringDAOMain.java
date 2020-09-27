package bcntec.spring.data.a_jpa_dao;


import bcntec.spring.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.EntityManager;


/*@RunWith(SpringRunner.class)
@Sql(scripts = "/projection-insert-data.sql")
@Sql(scripts = "/projection-clean-up-data.sql", executionPhase = AFTER_TEST_METHOD)
*/
@ComponentScan(value = {"bcntec.spring.data.entities", "bcntec.spring.data.a_jpa_dao"},
        basePackageClasses = UserDAO.class)
@EntityScan(basePackageClasses = UserEntity.class)
@SpringBootApplication(scanBasePackageClasses = {SpringDAOMain.class},
        exclude = {SecurityAutoConfiguration.class})
public class SpringDAOMain {
    @Autowired
    EntityManager entityManager;
    @Autowired
    UserDAO userDAO;


    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(SpringDAOMain.class).run(args);
    }

}
