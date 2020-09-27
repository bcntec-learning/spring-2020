package bcntec.spring.configuration.centralized;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.cloud.context.config.annotation.RefreshScope;

//@Profile("configuration-client")
@SpringBootApplication(scanBasePackageClasses = ConfigurationClientApplication.class)
public class ConfigurationClientApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ConfigurationServiceApplication.class);
        application.setAdditionalProfiles("configuration-client");
        application.run(args);
    }

    //@RefreshScope
    @RestController
    public static class MessageRestController {

        @Value("${message:Hello default}")
        private String message;

        @GetMapping("/message")
        public String getMessage() {
            return this.message;
        }
    }
}
