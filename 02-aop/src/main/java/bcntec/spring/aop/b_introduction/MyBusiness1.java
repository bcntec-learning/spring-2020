package bcntec.spring.aop.b_introduction;

import java.util.Random;

public class MyBusiness1 {

    @MyAudit("WHO")
    public String who() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {

        }
        who2(); // no hay AOP
        return "me";
    }


    @MyAudit("WHO2")
    public void who2(){
        System.out.println("who2");
    }
}
