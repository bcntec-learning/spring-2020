package bcntec.spring.mvc.controlleradvice;


public class MyResponse {
    String message;

    public MyResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
