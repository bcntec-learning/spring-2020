package bcntec.spring.beans.b_injection;

import bcntec.spring.beans.FirstBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class MyFirstBySetter implements FirstBean {
    private FirstBean bean1;
    private FirstBean bean2;


    @Override
    public String hello() {
        return new StringBuilder(bean1.hello())
                .append("->").append(bean2.hello()).toString();
    }

    @Qualifier("2")
    @Autowired
    public void setBean1(FirstBean bean) {
        this.bean1 = bean;
        System.err.println("!!!!! bean 2");
    }

    @Resource(name = "myFirstBean2")  // es igual a @Autowired("myFirstBean2")
    public void setBean2(FirstBean bean) {
        this.bean2 = bean;
    }
}
