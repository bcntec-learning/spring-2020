package bcntec.spring.data.d_rest;

import bcntec.spring.data.entities.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)
@EntityScan(basePackageClasses = UserEntity.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner initialize(UserService userService) {
        return args -> {
            try {
                //System.out.println(userService.create("Juanito"));

                userService.create("Juanito", "Roberta", "Ignasio", "Mario", "Honorio")
                        .forEach(System.out::println);
            } finally {
                userService.getUserRepository().findAll().forEach(System.out::println);
            }
        };
    }


}
