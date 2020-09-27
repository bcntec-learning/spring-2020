package bcntec.spring.beans.test;


import bcntec.spring.beans.FirstBean;
import bcntec.spring.beans.b_injection.InjectAndAutoWiredContext;
import bcntec.spring.beans.b_injection.MyFirstBean;
import bcntec.spring.beans.b_injection.MyFirstByConstructor;
import bcntec.spring.beans.b_injection.MyFirstBySetter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InjectAndAutoWiredContext.class})
public class TestAutowired {

    @Autowired
    MyFirstBean byType;

    @Qualifier("2")
    @Autowired
    FirstBean byQualifier;

    @Resource(name = "myFirstBean")
    FirstBean byName;

    @Inject
    MyFirstBySetter bySetter;

    @Inject
    @Named("myFirstBean")
    FirstBean byName2;

    @Autowired
    MyFirstByConstructor byConstructor;

    @Test
    public void first_not_null() {
        assertNotNull(byType);
        System.err.println(byType.hello());
        ;

    }

    @Test
    public void byName_not_null() {
        assertNotNull(byName);
        System.err.println(byName.hello());

    }


    @Test
    public void byQualifier_not_null() {
        assertNotNull(byQualifier);
        System.err.println(byQualifier.hello());
        assertEquals("hello sub2 MyFirstBean2_2!!!!!!", byQualifier.hello());

    }

    @Test
    public void bySetter_not_null() {
        assertNotNull(bySetter);
        System.err.println(bySetter.hello());
        assertEquals("hello sub2 MyFirstBean2_2!!!!!!->hello sub2 MyFirstBean2!!!!!!", bySetter.hello());

    }

    @Test
    public void byConstructor_not_null() {
        assertNotNull(byConstructor);
        System.err.println(byConstructor.hello());

    }

}
