package bcntec.spring.configuration.properties.test;

import bcntec.spring.configuration.properties.SpringNameComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringNameComponent.class)
@SpringBootTest
public class PropertiesValuesEnvironmentTest {

    @Value("${lc_ctype}")
    private String ctype0;
    @Value("${lc.ctype}")
    private String ctype1;

    @Value("${LC.CTYPE}")
    private String ctype2;

    @Value("${LC_CTYPE}")
    private String ctype3;

    @Test
    public void validate_ctype_lowercase_env_name() {
        assertEquals(System.getenv("LC_CTYPE"), ctype0);
    }

    @Test
    public void validate_ctype_with_dot_separator_lowercase() {
        assertEquals(System.getenv("LC_CTYPE"), ctype1);
    }

    @Test
    public void validate_ctype_with_dot_separator_uppercase() {
        assertEquals(System.getenv("LC_CTYPE"), ctype2);
    }

    @Test
    public void validate_ctype_exactly_env_name() {
        assertEquals(System.getenv("LC_CTYPE"), ctype3);
    }


}
