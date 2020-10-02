package bcntec.spring.mvc.configurer.sample1;

import bcntec.spring.mvc.binder.sample1.MyEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.PropertyEditorSupport;

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
    public ResponseEntity<String> ok1(@Tracker Long track, @RequestParam("param") String param) {
        log.info("track:" + track);
        return ResponseEntity.ok(param);

    }


}

