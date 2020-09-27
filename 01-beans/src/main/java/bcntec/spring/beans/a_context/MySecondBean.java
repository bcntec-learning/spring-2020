package bcntec.spring.beans.a_context;

import bcntec.spring.beans.FirstBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class MySecondBean implements BeanFactoryAware {
    //@Autowired //que es igual a @Inject
    private MyFirstBean myFirstBean;

    private BeanFactory beanFactory;


    @Autowired
    public MySecondBean(MyFirstBean myFirstBean) {
        this.myFirstBean = myFirstBean;
    }

    public void hello() {
        myFirstBean.hello();
    }

    public void hello(String q) {
        beanFactory.getBean(q, FirstBean.class).hello();
    }

    //@Autowired
    public void setMyFirstBean(MyFirstBean myFirstBean) {
        this.myFirstBean = myFirstBean;

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
