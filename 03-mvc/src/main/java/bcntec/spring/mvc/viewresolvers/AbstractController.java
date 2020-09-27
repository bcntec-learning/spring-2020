package bcntec.spring.mvc.viewresolvers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public abstract class AbstractController {


    @GetMapping("/echo")
    public String echo(@RequestParam(name = "text", required = false, defaultValue = "Echoooo") String text,
                       Model model) {
        model.addAttribute("echoText", text);
        return "echo";
    }

    @GetMapping("/echo2")
    public String echo2(@RequestParam(name = "text", required = false, defaultValue = "Echoooo") String text, Model model) {
        model.addAttribute("echoText", text);
        return "echo2";
    }

    @GetMapping("/echo3")
    public ModelAndView echo3(@RequestParam(name = "text", required = false, defaultValue = "Echoooo") String text) {
        ModelAndView model = new ModelAndView();
        model.addObject("echoText", text);
        model.setViewName("echo3");
        return model;
    }
}
