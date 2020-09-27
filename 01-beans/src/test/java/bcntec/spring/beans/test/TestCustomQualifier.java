package bcntec.spring.beans.test;


import bcntec.spring.beans.c_custom_qualifier.Custom;
import bcntec.spring.beans.c_custom_qualifier.InjectAndAutoWiredContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InjectAndAutoWiredContext.class})
public class TestCustomQualifier {

    //@CustomQualifier(status = StatusType.A)
    @Autowired
    Custom custom;


    @Test
    public void custom() {
        assertNotNull(custom);

    }

}
