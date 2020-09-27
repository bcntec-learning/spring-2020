package bcntec.spring.data.d_rest;

import bcntec.spring.data.entities.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<UserEntity> create(String... names) {
//
        try {
            Stream.of(names).forEach(this::create);
        } catch (RuntimeException e) {
        }
//
        userRepository.findAll().forEach(System.out::println);
        /*
        if(userRepository!=null) { //hace rollback
            throw new RuntimeException("hola");
        }
         */
        return userRepository.findAll();
    }

    @Transactional(propagation = MANDATORY, noRollbackFor = RuntimeException.class)
    public UserEntity create(String name) {
        UserEntity user = new UserEntity(name, name + "@bcntec");

        user = userRepository.save(user);

        if ((user.getId() % 2) == 0) {
            throw new RuntimeException("aloooo");
        }
        return user;
    }


    public UserRepository getUserRepository() {
        return userRepository;
    }
}
