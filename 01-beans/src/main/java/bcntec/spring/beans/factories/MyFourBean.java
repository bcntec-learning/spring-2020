package bcntec.spring.beans.factories;

import bcntec.spring.beans.FirstBean;
import org.springframework.stereotype.Component;

@Component
public class MyFourBean implements FirstBean {


    @Override
    public String hello() {
        return ("hello !!!!!!");
    }
}
