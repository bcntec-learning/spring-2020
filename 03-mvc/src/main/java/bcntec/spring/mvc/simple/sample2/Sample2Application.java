package bcntec.spring.mvc.simple.sample2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = {Sample2Controller.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class Sample2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sample2Application.class, args);
    }


}