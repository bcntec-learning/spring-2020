package bcntec.spring.mvc.argumentsresolvers.sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class Configurer1Configurer implements WebMvcConfigurer {

    @Autowired
    private TrackerArgumentResolver trackerArgumentResolver;

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        //argumentResolvers.add(new TrackerArgumentResolver());
        argumentResolvers.add(trackerArgumentResolver);
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

}
