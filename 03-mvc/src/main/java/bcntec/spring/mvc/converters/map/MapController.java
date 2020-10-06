package bcntec.spring.mvc.converters.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {

    @RequestMapping("/map1/{location}")
    public void locate(@PathVariable("location") String path){

    }

    @RequestMapping("/map2/{location}")
    public void locate(@PathVariable("location") Location location){


    }
}
