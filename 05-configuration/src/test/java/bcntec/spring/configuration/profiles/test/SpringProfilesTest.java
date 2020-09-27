package bcntec.spring.configuration.profiles.test;

import bcntec.spring.configuration.profiles.DatasourceConfig;
import bcntec.spring.configuration.profiles.DevDatasourceConfig;
import bcntec.spring.configuration.profiles.ProductionDatasourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;

@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DevDatasourceConfig.class, ProductionDatasourceConfig.class})
public class SpringProfilesTest {
    @Autowired
    DatasourceConfig datasourceConfig;



    /*
     AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
     ctx.register(DevDatasourceConfig.class);
     ctx.register(ProductionDatasourceConfig.class);
     ctx.refresh();

     */

    @Test
    public void setupDatasource() {
        assertTrue(datasourceConfig.setup().contains("DEV"));
    }
}