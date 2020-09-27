package bcntec.spring.mvc.configurer.sample1;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class TrackerArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //parameter.hasParameterAnnotation()
        //parameter.getParameterName()
        return String.class.isAssignableFrom(parameter.getParameterType()) &&
                parameter.hasParameterAnnotation(Tracker.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String header = webRequest.getHeader("my-tracker");
        if (header != null && !header.trim().isEmpty()) {
            return header.trim();
        } else {
            return null;
        }
    }
}
