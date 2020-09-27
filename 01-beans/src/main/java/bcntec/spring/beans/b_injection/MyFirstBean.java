package bcntec.spring.beans.b_injection;


import bcntec.spring.beans.FirstBean;
import org.springframework.stereotype.Component;


@Component
public class MyFirstBean implements FirstBean {


    @Override
    public String hello() {
        return "hello  !!!!!!";
    }


}
