package bcntec.spring.mvc.viewresolvers.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@EnableWebMvc
@Configuration
public class ResourceViewer1MvcConfigurer implements WebMvcConfigurer {


    @Bean
    public ViewResolver resourceBundleViewResolver() {
        ResourceBundleViewResolver bean = new ResourceBundleViewResolver();
        bean.setBundleClassLoader(ResourceViewer1MvcConfigurer.class.getClassLoader());
        return bean;
    }

}
