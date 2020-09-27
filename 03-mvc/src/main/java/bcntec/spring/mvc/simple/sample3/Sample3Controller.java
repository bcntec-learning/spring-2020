package bcntec.spring.mvc.simple.sample3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class Sample3Controller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showForm() {
        //base dat0s?
        ModelAndView m = new ModelAndView();
        m.setViewName("add");
        m.getModelMap().addAttribute("customer", new Customer("name", 1L, "email@domain"));
        return m;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("customer") Customer customer,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("customer", customer);
        return "view";
    }
}