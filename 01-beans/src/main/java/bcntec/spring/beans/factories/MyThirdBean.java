package bcntec.spring.beans.factories;

import bcntec.spring.beans.FirstBean;

public class MyThirdBean implements FirstBean {
    private final String name;

    public MyThirdBean(FirstBean bean) {
        name = bean.hello();
    }

    public MyThirdBean(String name) {
        this.name = name;
    }


    @Override
    public String hello() {
        return ("hello " + name + "!!!!!!");
    }
}
