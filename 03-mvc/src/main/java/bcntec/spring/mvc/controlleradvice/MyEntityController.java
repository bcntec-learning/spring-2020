package bcntec.spring.mvc.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping("/")
public class MyEntityController {

    private final MyEntityService myEntityService;

    public MyEntityController(MyEntityService myEntityService) {
        this.myEntityService = myEntityService;
    }

    @ResponseBody
    @RequestMapping(value = "/1/{i}",
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> find(@PathVariable(name = "i") Integer pk) {

        return ResponseEntity.status(pk == 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(myEntityService.process(pk));


    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/2/{i}",
            produces = APPLICATION_JSON_VALUE)
    public String find2(@PathVariable(name = "i") Integer pk) {
        return myEntityService.process(pk);
    }


}

