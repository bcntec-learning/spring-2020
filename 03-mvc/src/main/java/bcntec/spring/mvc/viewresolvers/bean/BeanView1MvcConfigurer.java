package bcntec.spring.mvc.viewresolvers.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class BeanView1MvcConfigurer implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        registry.viewResolver((viewName, locale) -> {
            System.err.println("que buscas?" + viewName);
            return null;
        });

        registry.beanName();
    }
}
