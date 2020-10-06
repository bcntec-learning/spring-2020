package bcntec.spring.mvc.converters.map;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MapConfigurer implements WebMvcConfigurer {


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToLocationConverter());
    }

    static class StringToLocationConverter implements Converter<String, Location> {
        @Override
        public Location convert(String source) {
            return new Location(source);
        }

    }

}
