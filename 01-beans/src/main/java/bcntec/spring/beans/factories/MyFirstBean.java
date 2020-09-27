package bcntec.spring.beans.factories;


import bcntec.spring.beans.FirstBean;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class MyFirstBean implements FirstBean, BeanNameAware, BeanPostProcessor {
    private String myName;

    public String getMyName() {
        return myName;
    }

    @Override
    public String hello() {
        return ("hello " + myName + "!!!!!!");
    }


    @Override
    public void setBeanName(String name) {
        this.myName = name;
    }

    /* see MyFirstAOPBean
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Serializable){
        return bean;
        }
        throw new BeanCreationException("no eres serializable");
    }
     */


    @PostConstruct
    public void p0() {
        System.err.println("constructed " + myName);
    }

    @PreDestroy
    public void p1() {
        System.err.println("destroying " + myName);
    }
}
