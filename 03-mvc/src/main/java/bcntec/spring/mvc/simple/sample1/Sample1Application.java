package bcntec.spring.mvc.simple.sample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = {Sample1Controller.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class Sample1Application {

    public static void main(String[] args) {

        SpringApplication.run(Sample1Application.class, args);
    }


}