package bcntec.spring.beans.test;


import bcntec.spring.beans.c_custom_qualifier.Custom;
import bcntec.spring.beans.c_custom_qualifier.CustomQualifier;
import bcntec.spring.beans.c_custom_qualifier.InjectAndAutoWiredContext;
import bcntec.spring.beans.c_custom_qualifier.StatusType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InjectAndAutoWiredContext.class})
public class TestCustomQualifier {

    @Autowired
    Custom custom;

    //@Qualifier("a")  //debilemente tipado
    @CustomQualifier(status = StatusType.A)  //fuertemente tipado
    @Autowired
    Custom customA;
    @CustomQualifier(status = StatusType.B)
    @Autowired
    Custom customB;


    @Test
    public void custom_Primary_expected() {
        assertNotNull(custom);
        assertEquals("B", custom.getId());

    }

    @Test
    public void custom_B_expected() {
        assertNotNull(customB);
        assertEquals("B", customB.getId());

    }
    @Test
    public void custom_A_expected() {
        assertNotNull(customA);
        assertEquals("A", customA.getId());

    }

}
