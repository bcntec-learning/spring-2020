package bcntec.spring.mvc.binder.sample1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackageClasses = {BindingMain.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class BindingMain {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(BindingMain.class).run(args);
    }

}

