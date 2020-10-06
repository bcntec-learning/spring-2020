package bcntec.spring.mvc.argumentsresolvers.sample1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Configurer1Controller {
    private static final Logger log = LoggerFactory.getLogger(Configurer1Controller.class);



    @ResponseBody
    @RequestMapping(value = "/ok1")
    public ResponseEntity<String> ok1(@Tracker String track, @RequestParam("param") String param) {
        log.info("track:" + track);
        return ResponseEntity.ok(param);

    }

    @ResponseBody
    @RequestMapping(value = "/ok2")
    public ResponseEntity<String> ok2(TrackerID track, @RequestParam("param") String param) {
        log.info("track:" + track);
        return ResponseEntity.ok(param);

    }

    @ResponseBody
    @RequestMapping(value = "/no-ok")
    public ResponseEntity<String> noOk(@Tracker Long track, @RequestParam("param") String param) {
        log.info("track:" + track);
        return ResponseEntity.ok(param);

    }


    @ResponseBody
    @RequestMapping(value = "/header")
    public ResponseEntity<String> header(@RequestHeader("my-tracker") String track, @RequestParam("param") String param) {
        log.info("track:" + track);
        return ResponseEntity.ok(param);

    }


}

