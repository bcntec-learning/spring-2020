package bcntec.spring.mvc.configurer.sample1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Configurer1Controller {
    private static final Logger log = LoggerFactory.getLogger(Configurer1Controller.class);


    @ResponseBody
    @RequestMapping(value = "/")
    public ResponseEntity<String> intercepter(@Tracker String track, @RequestParam("param") String param) {
        log.info("track:" + track);
        return ResponseEntity.ok(param);

    }


}

