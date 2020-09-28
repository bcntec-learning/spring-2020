package bcntec.spring.beans.a_context.sub;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("2")
@Component
public class SubMyFirstBean2 extends SubMyFirstBean {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
