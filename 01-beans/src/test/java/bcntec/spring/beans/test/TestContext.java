package bcntec.spring.beans.test;


import bcntec.spring.beans.FirstBean;
import bcntec.spring.beans.a_context.MyFirstBean;
import bcntec.spring.beans.a_context.MyFirstContext1;
import bcntec.spring.beans.a_context.MySecondBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyFirstContext1.class})
public class TestContext {

    @Autowired
    MyFirstBean myFirstBean;

    @Autowired
    MySecondBean b;


    @Test
    public void first_not_null() {
        assertNotNull(myFirstBean);
        String s = myFirstBean.hello();
        assertEquals("hello myFirstBean!!!!!!", s);

    }


    @Test
    public void second_not_null() {
        assertNotNull(b);
        b.hello();

    }
}
