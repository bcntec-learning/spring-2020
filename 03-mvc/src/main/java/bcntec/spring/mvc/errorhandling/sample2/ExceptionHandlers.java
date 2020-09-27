package bcntec.spring.mvc.errorhandling.sample2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlers.class);


    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleAccountNotFoundException(final AccountNotFoundException ex) {
        log.error("Account not found thrown", ex);
        return new AccountResponse("ACCOUNT_NOT_FOUND", "The account was not found", ex.getId());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ErrorResponse handleThrowable(final Throwable ex) {
        log.error("Unexpected error", ex);
        return new ErrorResponse("INTERNAL_SERVER_ERROR", "An unexpected internal server error occured");
    }


    public static class ErrorResponse {
        private final String code;
        private final String message;

        public ErrorResponse(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }


    public static class AccountResponse extends ErrorResponse {
        private final Integer id;

        public AccountResponse(String code, String message, Integer id) {
            super(code, message);
            this.id = id;
        }
    }
}