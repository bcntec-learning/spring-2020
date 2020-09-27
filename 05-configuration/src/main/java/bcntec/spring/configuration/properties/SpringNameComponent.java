package bcntec.spring.configuration.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringNameComponent {

    @Value("${spring.application.name}")
    private String name;


    public String getName() {
        return name;
    }
}
