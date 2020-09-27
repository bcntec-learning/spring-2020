package bcntec.spring.mvc.configurer.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasciContooller {

    @RequestMapping("/home2")
    public String home(Model model) {
        return "vista";
    }

    @RequestMapping("/home3")
    public ModelAndView home3(Model model) {
        model.addAttribute("hola", "mundo");
        return new ModelAndView("vista", model.asMap());
    }
    /*
    @RequestMapping("/home3")
    public View home3(Model model){
       return "vista";
    }
     */
}
