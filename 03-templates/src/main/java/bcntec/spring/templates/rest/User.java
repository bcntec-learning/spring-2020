package bcntec.spring.templates.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private Long id;
    @JsonProperty("name")
    private String name2;
    private String email;

    public User() {
    }

    public User(Long id, String name2, String email) {
        this.id = id;
        this.name2 = name2;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
