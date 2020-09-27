package bcntec.spring.configuration.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevDatasourceConfig implements DatasourceConfig {
    @Override
    public String setup() {
        return ("Setting up datasource for DEV environment. ");
    }
}