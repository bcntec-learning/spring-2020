package bcntec.spring.mvc.configurer.basic;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackageClasses = {BasicMain.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class BasicMain {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(BasicMain.class).run(args);
    }

}

