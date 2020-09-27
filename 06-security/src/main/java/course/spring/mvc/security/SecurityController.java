package course.spring.mvc.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {


    @GetMapping(value = "/")
    public String home() {
        return "home";
    }

}