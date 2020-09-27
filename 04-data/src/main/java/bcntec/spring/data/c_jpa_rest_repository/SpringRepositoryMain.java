package bcntec.spring.data.c_jpa_rest_repository;


import bcntec.spring.data.a_jpa_dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

@SpringBootApplication(scanBasePackageClasses = {SpringRepositoryMain.class},
        exclude = {SecurityAutoConfiguration.class})
public class SpringRepositoryMain {
    @Autowired
    EntityManager entityManager;
    @Autowired
    UserRestRepository userRepository;


    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(SpringRepositoryMain.class).run(args);
    }

}
