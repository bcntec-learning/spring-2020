package bcntec.spring.aop.b_introduction;

import java.util.Random;

public class MyBusiness2 implements MyBusiness {

    public void runNow() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {

        }
        new MyBusiness2().runNow(); // no hay AOP
    }

    public void throwMyException() {
        throw new MyException();
    }
}
