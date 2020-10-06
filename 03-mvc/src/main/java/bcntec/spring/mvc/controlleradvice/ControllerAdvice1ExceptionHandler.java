package bcntec.spring.mvc.controlleradvice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //AOP
public class ControllerAdvice1ExceptionHandler extends ResponseEntityExceptionHandler {

    public ControllerAdvice1ExceptionHandler() {
        super();
    }

    @ExceptionHandler({MyEntityNotFoundException.class, NotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, new MyErrorResponse("not found!!!!"), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Object> handleNullPointer(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, new MyErrorResponse(ex
                .getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, new MyErrorResponse(ex
                .getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}