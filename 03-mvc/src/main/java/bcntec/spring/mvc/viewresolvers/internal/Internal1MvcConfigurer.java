package bcntec.spring.mvc.viewresolvers.internal;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
public class Internal1MvcConfigurer implements WebMvcConfigurer {


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        //resolver.setViewClass(RawView.class);
        resolver.setPrefix("/jsp2/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(1);
        //other way -> registry.jsp("/jsp2/", ".jsp").
        registry.viewResolver(resolver); //
    }


}
