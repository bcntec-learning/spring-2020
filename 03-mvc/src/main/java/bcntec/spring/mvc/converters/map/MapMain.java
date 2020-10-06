package bcntec.spring.mvc.converters.map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackageClasses = {MapMain.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class MapMain {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(MapMain.class).run(args);
    }

}

