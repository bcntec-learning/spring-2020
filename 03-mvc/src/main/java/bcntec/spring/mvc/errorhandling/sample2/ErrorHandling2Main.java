package bcntec.spring.mvc.errorhandling.sample2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackageClasses = {ErrorHandling2Main.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class ErrorHandling2Main {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ErrorHandling2Main.class).run(args);
    }

}

