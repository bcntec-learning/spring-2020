package bcntec.spring.beans.a_context;

import bcntec.spring.beans.FirstBean;

public class MyThirdBean implements FirstBean {
    private final String name;

    public MyThirdBean(String name) {
        this.name = name;
    }


    @Override
    public String hello() {

        return ("hello " + name + "!!!!!!");
    }
}
