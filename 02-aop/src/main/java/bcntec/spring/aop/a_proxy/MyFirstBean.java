package bcntec.spring.aop.a_proxy;


public class MyFirstBean implements FirstBean {


    @Override
    public void hello(String name) {
        System.err.println("hello " + name + "!!!!!!");
    }


}
