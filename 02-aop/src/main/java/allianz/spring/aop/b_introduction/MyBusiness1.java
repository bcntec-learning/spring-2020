package bcntec.spring.aop.b_introduction;

import java.util.Random;

public class MyBusiness1 {

    @MyAudit
    public String who() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {

        }
        return "me";
    }
}
