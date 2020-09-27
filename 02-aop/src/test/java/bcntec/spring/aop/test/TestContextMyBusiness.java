package bcntec.spring.aop.test;


import bcntec.spring.aop.b_introduction.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyBusinessContext.class})
public class TestContextMyBusiness {

    @Autowired
    MyBusiness1 myBusiness1;

    @Autowired
    MyBusiness2 myBusiness2;

    @Autowired
    MyBusiness myBusiness22;

    @Autowired
    private List<String> accumulator;

    @Before
    public void reset() {
        accumulator.clear();
    }

    @Test
    public void myBusiness_not_null() {
        assertNotNull(myBusiness1);
        assertNotNull(myBusiness2);

    }

    @Test
    public void myBusiness_invoke() {
        assertNotNull(myBusiness1);
        assertNotNull(myBusiness2);
        myBusiness1.who();
        assertEquals(2, accumulator.size());
        myBusiness2.runNow();
        assertEquals(3, accumulator.size());
    }

    @Test(expected = MyException.class)
    public void myBusiness_exception_invoke() {
        try {

            myBusiness2.throwMyException();
        } finally {
            assertEquals("Error MyException",
                    accumulator.stream().filter(a -> a.startsWith("Error")).findFirst().get());

        }
        fail();


    }

}
