package bcntec.spring.mvc.errorhandling.sample3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers extends BaseExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlers.class);


    public ExceptionHandlers() {
        super(log);
    }

    @ExceptionHandler(InvoiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleInvoiceNotFoundException(final InvoiceNotFoundException ex) {
        log.error("Invoice not found thrown", ex);
        return new ErrorResponse("INVOICE_NOT_FOUND", "The invoice was not found");
    }
}