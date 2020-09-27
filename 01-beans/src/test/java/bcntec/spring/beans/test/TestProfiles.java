package bcntec.spring.beans.test;


import bcntec.spring.beans.profiles.FourthBean;
import bcntec.spring.beans.profiles.MyProfilesContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@ActiveProfiles("bean2")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyProfilesContext.class})
public class TestProfiles {


    @Autowired
    FourthBean fourthBean;


    @Test
    public void profile2_not_null() {
        assertNotNull(fourthBean);
        System.err.println(fourthBean);

    }

}
