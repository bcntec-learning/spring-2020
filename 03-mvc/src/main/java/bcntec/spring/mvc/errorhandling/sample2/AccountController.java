package bcntec.spring.mvc.errorhandling.sample2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Controller
@RequestMapping("/accounts")
public class AccountController {


    @ResponseBody
    @RequestMapping(value = "/{i}",
            produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> find(@PathVariable(name = "i") Integer pk) {
        switch (pk) {
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body("{\"account\":{ \"pk\":\"" + pk + "\"}}");

            case 2:

                throw new AccountNotFoundException(pk);
            default:
                throw new IllegalArgumentException();

        }
    }

}
