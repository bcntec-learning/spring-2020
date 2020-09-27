package bcntec.spring.mvc.simple.sample2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@EnableWebMvc
@Configuration
public class Sample2MvcConfigurer implements WebMvcConfigurer {


    @Bean
    public ViewResolver resourceBundleViewResolver() {
        ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
        resolver.setBundleClassLoader(Sample2MvcConfigurer.class.getClassLoader());
        resolver.setBasename("sample2");
        return resolver;
    }

}
