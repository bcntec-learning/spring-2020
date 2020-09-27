package bcntec.spring.mvc.viewresolvers.xml;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.XmlViewResolver;

@EnableWebMvc
@Configuration
public class Xml1MvcConfigurer implements WebMvcConfigurer {


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        XmlViewResolver bean = new XmlViewResolver();
        bean.setLocation(new ClassPathResource("views.xml"));
        registry.viewResolver(bean);
    }

}
