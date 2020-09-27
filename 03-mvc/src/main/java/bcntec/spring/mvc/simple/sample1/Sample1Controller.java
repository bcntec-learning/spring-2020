package bcntec.spring.mvc.simple.sample1;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class Sample1Controller {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {

        return "redirect:/html/index.html";

        //return new ModelAndView("redirect:/html/index.html");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @RequestMapping(value = "/add0", method = RequestMethod.POST)
    public String submit(HttpServletRequest request) {
        return "user0 '" + new User(
                request.getParameter("name"),
                new Long(request.getParameter("id")),
                request.getParameter("email")) + "' created ";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @RequestMapping(value = "/add1", method = RequestMethod.POST)
    public String submit(ModelMap model) {
        Map<String, Object> map = model;
        return "user1 '" + new User(
                (String) map.get("name"),
                new Long((String) map.get("id")),
                (String) map.get("email")) + "' created ";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @RequestMapping(value = "/add2", method = RequestMethod.POST)
    public String submit(@RequestParam(required = false) String name,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) Long id) {

        return "user2 '" + new User(name, id, email) + "' created ";
    }


    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    //@PostMapping("/add3")
    @RequestMapping(value = "/add3", method = RequestMethod.POST)
    public String submit(User user) {

        return "user3 '" + user + "' created ";
    }
}