package bcntec.spring.mvc.returnresolvers.sample1;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class ReturnResolvers1Config implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        //argumentResolvers.add();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter();
        //registry.addConverterFactory();
    }

}
