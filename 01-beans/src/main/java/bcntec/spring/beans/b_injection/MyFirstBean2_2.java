package bcntec.spring.beans.b_injection;

import bcntec.spring.beans.FirstBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Qualifier("2")
@Component
public class MyFirstBean2_2 implements FirstBean {

    @Override
    public String hello() {
        return ("hello sub2 " + getClass().getSimpleName() + "!!!!!!");
    }

}
