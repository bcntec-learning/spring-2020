package bcntec.spring.mvc.servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackageClasses = ServletWebConfigurer.class)
@EnableWebMvc
public class ServletWebConfigurer implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/META-INF/servlet/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // API
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/homepage.html");
    }

}