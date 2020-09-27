package bcntec.spring.beans.factories;

import bcntec.spring.beans.FirstBean;

public class MyLastBean implements FirstBean {
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String hello() {
        return ("hello " + name + "!!!!!!");
    }
}
