package bcntec.spring.mvc.viewresolvers.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {ResourceViewer1Application.class})
public class ResourceViewer1Application {
    public static void main(String[] args) {
        SpringApplication.run(ResourceViewer1Application.class, args);
    }


}