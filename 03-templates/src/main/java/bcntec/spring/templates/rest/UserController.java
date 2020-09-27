package bcntec.spring.templates.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(value = "/list")
    public List<User> list() {


        List<User> users = userService.list();


        return users;
    }


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(value = "/list-feign")
    public List<User> listFeign() {


        List<User> users = userService.listFeign();


        return users;
    }


}
