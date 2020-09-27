package bcntec.spring.mvc.errorhandling.sample1;

public class User {
    private Long pk;

    public User() {
    }

    public User(Long pk) {
        this.pk = pk;
    }

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }
}
