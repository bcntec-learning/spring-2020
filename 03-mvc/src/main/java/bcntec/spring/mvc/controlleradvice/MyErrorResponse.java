package bcntec.spring.mvc.controlleradvice;


public class MyErrorResponse {
    String message;

    public MyErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
