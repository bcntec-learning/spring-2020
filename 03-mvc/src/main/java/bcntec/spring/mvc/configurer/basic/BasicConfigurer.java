package bcntec.spring.mvc.configurer.basic;

import bcntec.spring.mvc.configurer.sample1.TrackerArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Configuration
public class BasicConfigurer implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new TrackerArgumentResolver());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter(new StringToTradeConverter());

        //registry.addConverterFactory(new StringToMyEnumsConverterFactory());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("file:/resources/", "classpath:/resources/")
                .setCachePeriod(3600);

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/maison").setViewName("home");
        registry.addViewController("/casa").setViewName("home");
        registry.addViewController("/doma").setViewName("home");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

    }


    @Bean
    public ViewResolver resourceBundleViewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setViewClass(BasicView.class);
        resolver.setOrder(1);
        return resolver;

    }
}
