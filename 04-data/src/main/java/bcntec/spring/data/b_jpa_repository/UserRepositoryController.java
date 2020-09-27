package bcntec.spring.data.b_jpa_repository;

import bcntec.spring.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserRepositoryController {
    @Autowired
    UserRepository userRepository;


    @Transactional(readOnly = true) //evitaria el lazy loading exception
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(value = "/list")
    public List<UserEntity> list() {

        List<UserEntity> users = userRepository.findAllByOrderByNameAsc();
        users.forEach(u -> {
            u.setEmail(u.getEmail().toUpperCase());
            u.setName(null);
            u.setVersion(null);

        });

        return users;
    }

    @Transactional(readOnly = true) //evitaria el lazy loading exception
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(value = "/q")
    public Page<UserEntity> list(@RequestParam(required = false) String name, Pageable page) {

        return userRepository.findAllByNameLikeOrderByNameAsc(name + "%", page);

    }

    @Transactional(readOnly = true) //evitaria el lazy loading exception
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(value = "/q/{page}")
    public Page<UserEntity> q2(@RequestParam(required = false, defaultValue = "") String name,
                               @PathVariable("page") Integer page,
                               @RequestParam(required = false, defaultValue = "5") Integer size) {


        return userRepository.findAllByNameLikeOrderByNameAsc(name + "%", PageRequest.of(page, size));

    }

    @Transactional(readOnly = true)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(value = "/names")
    public List<String> names() {

        return userRepository.listNames();

    }

    @Transactional(readOnly = true) //evitaria el lazy loading exception
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(value = "/list2")
    public List<UserEntity> list2() {

        List<UserEntity> users = userRepository.listMyOrder();

        return users;
    }

    @Transactional(readOnly = true) //evitaria el lazy loading exception
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(value = "/q2")
    public Page<UserEntity> list2(@RequestParam(required = false) String name, Pageable page) {

        return userRepository.listMyOrder(name, page);

        //userRepository.findAll(JpaSort.unsafe(Sort.Direction.ASC,"name"));
    }

    @ResponseBody
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public UserEntity insert(@RequestParam("name") String name,
                             @RequestParam("email") String email) {
        UserEntity e = userRepository.saveAndFlush(new UserEntity(name, email));
        return e;
    }

    @ResponseBody
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public UserEntity update(@PathVariable("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email) {
        Optional<UserEntity> optionalE = userRepository.findById(id);


        UserEntity e = optionalE.get();
        e.setName(name);
        e.setEmail(email);

        UserEntity r = userRepository.saveAndFlush(e);
        return r;

    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);

    }


}
