package bcntec.spring.beans.a_naming;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;

@Configuration
//@ComponentScan(value = "bcntec.spring.beans.b_naming") //generador estandar y con ello un formato de nombres
@ComponentScan(value = "bcntec.spring.beans.a_naming", nameGenerator = CustomNamingBeanContext.MyBeanNameGenerator.class)
public class CustomNamingBeanContext {

    static class MyBeanNameGenerator implements BeanNameGenerator {

        @Override
        public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
            return ClassUtils.getShortName(definition.getBeanClassName()) + "!plus";
        }
    }
}
