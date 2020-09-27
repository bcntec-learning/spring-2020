package bcntec.spring.data.c_jpa_rest_repository;

import bcntec.spring.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UserRepositoryController {
    @Autowired
    UserRestRepository repository;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(value = "/list")
    public Iterable<UserEntity> list() {
        return repository.findAll();
    }
}
