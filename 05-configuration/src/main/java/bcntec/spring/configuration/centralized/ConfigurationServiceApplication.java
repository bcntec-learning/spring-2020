package bcntec.spring.configuration.centralized;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.cloud.config.server.EnableConfigServer;

//@Profile("configuration-service")
//@EnableConfigServer
@SpringBootApplication(scanBasePackageClasses = ConfigurationServiceApplication.class)
public class ConfigurationServiceApplication {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ConfigurationServiceApplication.class);
        application.setAdditionalProfiles("configuration-service");
        application.run(args);
    }
}