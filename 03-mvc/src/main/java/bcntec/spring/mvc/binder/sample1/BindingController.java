package bcntec.spring.mvc.binder.sample1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@Controller
@RequestMapping("/")
public class BindingController {


    @ResponseBody
    @RequestMapping(value = "/{enum}", //method = RequestMethod.GET,
            produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MyEnum> find(@PathVariable(name = "enum") MyEnum myEnum) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(myEnum);


    }

    @ResponseBody
    @RequestMapping(value = "/{enum}", //method = RequestMethod.GET,
            produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<MyEnum> find2(@PathVariable(name = "enum") MyEnum myEnum) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(myEnum);


    }

}
