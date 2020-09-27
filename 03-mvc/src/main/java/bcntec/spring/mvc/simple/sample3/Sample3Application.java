package bcntec.spring.mvc.simple.sample3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = {Sample3Controller.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class Sample3Application {

    public static void main(String[] args) {
        SpringApplication.run(Sample3Application.class, args);
    }


}