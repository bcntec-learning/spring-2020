package bcntec.spring.mvc.errorhandling.sample4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlers extends BaseExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlers.class);


    public ExceptionHandlers() {
        super(log);
        registerMapping(MyEntityNotFoundException.class, "MY_ENTITY_NOT_FOUND", "My Entity not found", HttpStatus.NOT_FOUND);
    }
}