package bcntec.spring.mvc.errorhandling.sample2;


public class AccountNotFoundException extends RuntimeException {
    private Integer id;

    public AccountNotFoundException(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}