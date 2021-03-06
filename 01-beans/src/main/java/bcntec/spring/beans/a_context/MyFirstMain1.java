package bcntec.spring.beans.a_context;

import bcntec.spring.beans.FirstBean;
import bcntec.spring.beans.a_context.sub.SubMyFirstBean;
import bcntec.spring.beans.a_context.sub.SubMyFirstBean2;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class MyFirstMain1 {

    public static void main(String... args) {



        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(MyFirstContext1.class);
        ctx.refresh();


        SubMyFirstBean c = ctx.getBean(SubMyFirstBean2.class);
        System.err.println(c.hello());
        FirstBean cSub = ctx.getBean("subMyFirstBean", FirstBean.class);
        System.err.println(cSub.hello());
        
        Map<String, FirstBean> cIMap = ctx.getBeansOfType(FirstBean.class);
        for (Map.Entry<String, FirstBean> i : cIMap.entrySet()) {
            System.err.print("   "+i.getKey() + "--->>>");
            System.err.println(i.getValue().hello());
        }

        FirstBean z = BeanFactoryAnnotationUtils.qualifiedBeanOfType(ctx.getBeanFactory(), FirstBean.class, "2");
        System.err.println(z.hello());

        try {
            ctx.getBean(FirstBean.class);
        } catch (NoUniqueBeanDefinitionException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            ctx.getBean(Object.class);
        } catch (NoUniqueBeanDefinitionException exception) {
            System.err.println(exception.getMessage());
        }

        ctx.registerShutdownHook();

    }
}
