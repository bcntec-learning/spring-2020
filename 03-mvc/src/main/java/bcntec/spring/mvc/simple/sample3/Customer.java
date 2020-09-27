package bcntec.spring.mvc.simple.sample3;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
    @NotNull
    @Size(min = 5)
    private String name;

    @NotNull
    private Long id;

    @NotNull
    @Email
    private String email;

    public Customer(@NotNull @Size(min = 5) String name, @NotNull Long id, @NotNull @Email String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}