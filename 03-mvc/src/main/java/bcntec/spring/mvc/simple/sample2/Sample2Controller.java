package bcntec.spring.mvc.simple.sample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Sample2Controller {

    private final EmployeeValidator validator;

    @Autowired
    public Sample2Controller(EmployeeValidator validator) {
        this.validator = validator;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("add", "employee", new Employee());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee,
                         BindingResult result, ModelMap model) {
        validator.validate(employee, result);

        if (result.hasErrors()) {
            return "error";
        }

        model.addAttribute("employee", employee);

        return "view";
    }
}