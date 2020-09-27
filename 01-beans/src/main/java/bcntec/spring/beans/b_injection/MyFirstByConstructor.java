package bcntec.spring.beans.b_injection;

import bcntec.spring.beans.FirstBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class MyFirstByConstructor implements FirstBean {
    private FirstBean bean1;


    public MyFirstByConstructor(@Qualifier("2") FirstBean bean1) {
        this.bean1 = bean1;
    }

    @Override
    public String hello() {
        return bean1.hello();
    }

}
