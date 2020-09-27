package bcntec.spring.configuration.properties.test;

import bcntec.spring.configuration.properties.SpringNameComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringNameComponent.class)
@TestPropertySource(properties = {
        "spring.application.name=hola",
})
@SpringBootTest
public class PropertiesValuesFormTestPropertySourceTest {
    @Autowired
    SpringNameComponent component;

    @Value("${spring.application.name:default-name}")
    private String name;

    @Test
    public void validate_app_name() {
        assertEquals("hola", component.getName());
    }
}
