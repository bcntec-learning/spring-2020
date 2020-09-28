package bcntec.spring.beans.a_context.sub;

import bcntec.spring.beans.FirstBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope("prototype")
@Component("subMyFirstBean")
public class SubMyFirstBean implements FirstBean, BeanNameAware, BeanFactoryAware {

    private String myName;

    @Override
    public String hello() {
        return ("hello sub " + myName + "!!!!!!");
    }


    @Override
    public void setBeanName(String name) {
        this.myName = name;
    }


    @PostConstruct
    public void p0() {
        System.err.println("constructed " + myName);
    }

    @PreDestroy
    public void p1() {
        System.err.println("destroying " + myName);
    }

    public String getMyName() {
        return myName;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        try {
            beanFactory.getBean("myVariable");
        }catch (Exception ignored){

        }
    }
}
