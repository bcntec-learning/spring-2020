package bcntec.spring.beans.a_naming;

import bcntec.spring.beans.FirstBean;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomNamingBeanMain {

    public static void main(String... args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(CustomNamingBeanContext.class);
        ctx.refresh();
        MyFirstBean c = ctx.getBean(MyFirstBean.class);
        try {
            ctx.getBean("myFirstBean", FirstBean.class);
        }catch (NoUniqueBeanDefinitionException i){
            System.err.println("myFirstBean no existe");
        }
        FirstBean d = ctx.getBean("MyFirstBean!plus", FirstBean.class);
        System.err.println(c.hello());
        System.err.println(d.hello());
        ctx.registerShutdownHook();

    }
}
