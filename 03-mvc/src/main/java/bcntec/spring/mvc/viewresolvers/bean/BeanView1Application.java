package bcntec.spring.mvc.viewresolvers.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = {BeanView1Application.class},
        exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class BeanView1Application {

    public static void main(String[] args) {
        SpringApplication.run(BeanView1Application.class, args);
    }


}