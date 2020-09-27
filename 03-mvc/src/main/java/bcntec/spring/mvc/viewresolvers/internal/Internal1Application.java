package bcntec.spring.mvc.viewresolvers.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {Internal1Application.class})
public class Internal1Application {

    public static void main(String[] args) {
        SpringApplication.run(Internal1Application.class, args);
    }


}