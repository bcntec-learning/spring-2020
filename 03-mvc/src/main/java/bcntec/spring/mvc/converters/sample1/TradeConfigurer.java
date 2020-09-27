package bcntec.spring.mvc.converters.sample1;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class TradeConfigurer implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new HeaderSourceArgumentResolver());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToTradeConverter());
        registry.addConverter(new GenericBigDecimalConverter());
        registry.addConverter(new StringToTypeConverter());

        //registry.addConverterFactory(new StringToMyEnumsConverter());
    }

    static class StringToTradeConverter implements Converter<String, Trade> {
        @Override
        public Trade convert(String source) {
            String[] v = source.split(",");

            return new Trade(
                    new Long(v[0]),
                    Trade.Type.valueOf(v[1].toUpperCase()),
                    new BigDecimal(v[2])
            );
        }

    }

    static class StringToTypeConverter implements Converter<String, Trade.Type> {
        @Override
        public Trade.Type convert(String source) {

            return Trade.Type.valueOf(source.toUpperCase());
        }

    }

    static class GenericBigDecimalConverter implements Converter<String, BigDecimal> {
        @Override
        public BigDecimal convert(String source) {
            return new BigDecimal(source);
        }

    }


    static class HeaderSourceArgumentResolver implements HandlerMethodArgumentResolver {

        @Override
        public boolean supportsParameter(MethodParameter parameter) {
            return false;
        }

        @Override
        public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
            return null;
        }
    }
}
