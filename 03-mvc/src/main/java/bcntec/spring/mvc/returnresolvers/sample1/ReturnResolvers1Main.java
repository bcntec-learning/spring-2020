package bcntec.spring.mvc.returnresolvers.sample1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackageClasses = {ReturnResolvers1Main.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class ReturnResolvers1Main {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ReturnResolvers1Main.class).run(args);
    }

}

