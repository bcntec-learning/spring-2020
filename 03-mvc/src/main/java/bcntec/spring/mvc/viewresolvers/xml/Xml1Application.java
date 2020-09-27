package bcntec.spring.mvc.viewresolvers.xml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {Xml1Application.class})
public class Xml1Application {

    public static void main(String[] args) {
        SpringApplication.run(Xml1Application.class, args);
    }


}