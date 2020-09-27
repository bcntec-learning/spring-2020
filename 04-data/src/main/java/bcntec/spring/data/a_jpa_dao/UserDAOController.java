package bcntec.spring.data.a_jpa_dao;

import bcntec.spring.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class UserDAOController {
    @Autowired
    UserDAO userDAO;


    @Transactional(readOnly = true) //evitaria el lazy loading exception
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(value = "/list")
    public List<UserEntity> list() {

        List<UserEntity> users = userDAO.listOrderByName();

        return users;
    }

    @ResponseBody
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public UserEntity insert(@RequestParam("name") String name,
                             @RequestParam("email") String email) {
        UserEntity e = userDAO.persist(new UserEntity(name, email));
        e.setTrace(UUID.randomUUID().toString());
        return e;
    }

    @ResponseBody
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public UserEntity update(@PathVariable("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email) {
        UserEntity e = userDAO.findById(id);
        e.setName(name);
        e.setEmail(email);

        UserEntity r = userDAO.persist(e);
        return r;

    }

    @Transactional
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(
                    userDAO.deleteById(id) != null ? HttpStatus.OK : HttpStatus.NOT_FOUND
            ).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }


}
