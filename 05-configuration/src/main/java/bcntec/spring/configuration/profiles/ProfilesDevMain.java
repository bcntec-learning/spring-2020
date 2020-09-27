package bcntec.spring.configuration.profiles;

import bcntec.spring.configuration.centralized.ConfigurationServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = ProfilesDevMain.class)
public class ProfilesDevMain {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ConfigurationServiceApplication.class);
        application.setAdditionalProfiles("dev");
        application.run(args);
    }
}
