package bcntec.spring.mvc.simple.sample3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@EnableWebMvc
@Configuration
public class Sample3MvcConfigurer implements WebMvcConfigurer {


    @Bean
    public ViewResolver resourceBundleViewResolver() {
        ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
        resolver.setBundleClassLoader(Sample3MvcConfigurer.class.getClassLoader());
        resolver.setBasename("sample3");
        return resolver;
    }

}
