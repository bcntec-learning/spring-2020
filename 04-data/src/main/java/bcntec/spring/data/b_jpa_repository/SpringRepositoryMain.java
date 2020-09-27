package bcntec.spring.data.b_jpa_repository;


import bcntec.spring.data.entities.UserEntity;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;


/*@RunWith(SpringRunner.class)
@Sql(scripts = "/projection-insert-data.sql")
@Sql(scripts = "/projection-clean-up-data.sql", executionPhase = AFTER_TEST_METHOD)
*/
@ComponentScan(basePackageClasses = {UserEntity.class, UserRepository.class})
@EntityScan(basePackageClasses = UserEntity.class)
@SpringBootApplication(scanBasePackageClasses = {SpringRepositoryMain.class})
public class SpringRepositoryMain {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(SpringRepositoryMain.class).run(args);
    }

}
