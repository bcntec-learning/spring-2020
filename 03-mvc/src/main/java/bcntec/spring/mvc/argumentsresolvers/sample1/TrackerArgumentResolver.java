package bcntec.spring.mvc.argumentsresolvers.sample1;

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
        return TrackerID.class.isAssignableFrom(parameter.getParameterType()) ||
                parameter.hasParameterAnnotation(Tracker.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String header = webRequest.getHeader("my-tracker");
        if (header != null && !header.trim().isEmpty()) {
            if (TrackerID.class.isAssignableFrom(methodParameter.getParameterType())) {
                return new TrackerID(header.trim());
            }
            if (String.class.isAssignableFrom(methodParameter.getParameterType())) {
                return header.trim();
            }

            throw new IllegalArgumentException("no compatible");
        } else {
            return null;
        }
    }
}
