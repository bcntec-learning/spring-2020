package bcntec.spring.beans.a_naming;

import bcntec.spring.beans.FirstBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomNamingBeanMain {

    public static void main(String... args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext("path/to/applicationContext.xml");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(CustomNamingBeanContext.class);
        ctx.refresh();
        MyFirstBean c = ctx.getBean(MyFirstBean.class);
        //FirstBean d = ctx.getBean("myFirstBean", FirstBean.class);
        FirstBean d = ctx.getBean("MyFirstBean!plus", FirstBean.class);
        System.err.println(c.hello());
        System.err.println(d.hello());
        ctx.registerShutdownHook();

    }
}
