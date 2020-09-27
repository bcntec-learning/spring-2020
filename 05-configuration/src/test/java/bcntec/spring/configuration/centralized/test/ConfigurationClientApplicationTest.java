package bcntec.spring.configuration.centralized.test;

import bcntec.spring.configuration.centralized.ConfigurationClientApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.core.env.ConfigurableEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

//import org.springframework.cloud.context.refresh.ContextRefresher;

@Ignore
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ConfigurationClientApplicationTest {

    @Autowired
    private ConfigurableEnvironment environment;

    @Autowired
    private ConfigurationClientApplication.MessageRestController controller;

    ////private ContextRefresher refresher;

    @Test
    public void contextLoads() {
        assertThat(controller.getMessage()).isNotEqualTo("Hello test");
        TestPropertyValues
                .of("message:Hello test")
                .applyTo(environment);
        assertThat(controller.getMessage()).isNotEqualTo("Hello test");
        //  refresher.refresh();
        assertThat(controller.getMessage()).isEqualTo("Hello test");
    }

}