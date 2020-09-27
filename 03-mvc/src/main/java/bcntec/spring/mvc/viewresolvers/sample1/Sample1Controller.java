package bcntec.spring.mvc.viewresolvers.sample1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sample1Controller {

    @GetMapping("/pdf")
    public String echo(@RequestParam(name = "text", required = false, defaultValue = "Echoooo") String text, Model model) {
        model.addAttribute("text", text);
        return "pdf";
    }

    @GetMapping("/redirect")
    public String redirect() {
        return "pdf";
    }

}