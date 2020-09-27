package bcntec.spring.templates.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    MyTemplate restTemplate;
    @Autowired
    UserClient userClient;


    public List<User> list() {

        ResponseEntity<Users> ret = restTemplate.get("/list2", Users.class);


        return ret.getBody();
    }

    public List<User> listFeign() {
        return userClient.list();
    }
}
