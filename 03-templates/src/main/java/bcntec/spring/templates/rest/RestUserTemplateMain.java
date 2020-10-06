package bcntec.spring.templates.rest;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication(scanBasePackageClasses = RestUserTemplateMain.class)
public class RestUserTemplateMain {


    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(RestUserTemplateMain.class).run(args);
    }
}
