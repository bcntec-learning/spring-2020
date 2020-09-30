package bcntec.spring.beans.test;


import bcntec.spring.beans.factories.MyFactoryContext;
import bcntec.spring.beans.factories.MyThirdBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyFactoryContext.class})
public class TestFactories {


    @Qualifier("3")
    @Autowired
    MyThirdBean bean3;


    @Qualifier("4")
    @Autowired
    MyThirdBean bean4;


    @Test
    public void factory_3() {
        assertNotNull(bean3);
        assertEquals("hello hello !!!!!!!!!!!!", bean3.hello());
    }
    @Test
    public void factory_4() {
        assertNotNull(bean4);
        assertEquals("hello hello !!!!!!!!!!!!", bean4.hello());
    }

}
