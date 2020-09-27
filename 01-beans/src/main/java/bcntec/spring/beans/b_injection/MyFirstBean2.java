package bcntec.spring.beans.b_injection;

import bcntec.spring.beans.FirstBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("2")
@Component
public class MyFirstBean2 implements FirstBean {

    @Override
    public String hello() {
        return ("hello sub2 " + getClass().getSimpleName() + "!!!!!!");
    }

}
