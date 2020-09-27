package bcntec.spring.configuration.properties.test;

import bcntec.spring.configuration.properties.SpringNameComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;

@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringNameComponent.class)
@SpringBootTest
public class PropertiesValuesDevProfileTest {
    @Autowired
    SpringNameComponent component;

    @Value("${spring.application.name:default-name}")
    private String name;

    @Test //application-dev.properties
    public void validate_app_name() {
        assertEquals("<properties file>", component.getName());
    }
}
