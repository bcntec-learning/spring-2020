package bcntec.spring.beans.factories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "bcntec.spring.beans.factories")
public class MyFactoryContext {

    @Qualifier("0")
    @Bean  //@Producer
    public MyThirdBean myThirdBean0() {
        //if()
        return new MyThirdBean("0");
    }

    @Qualifier("1")
    @Bean  //@Producer
    public MyThirdBean myThirdBean1(MyFirstBean sub) {
        //if()
        return new MyThirdBean(sub.getMyName());
    }

    @Qualifier("2")
    @Bean  //@Producer
    public MyThirdBean myThirdBean2(MyFirstBean sub) {
        //if()
        return new MyThirdBean(sub.getMyName() + "!!!");
    }

    @Qualifier("3")
    @Bean  //@Producer
    public MyThirdBean myThirdBean3(MyFourBean sub) {
        //if()
        return new MyThirdBean(sub.hello());
    }

    @Qualifier("4")
    @Bean  //@Producer
    public MyThirdBean myThirdBean4(@Qualifier("3") MyThirdBean sub) {
        //if()
        return sub;
    }

}
