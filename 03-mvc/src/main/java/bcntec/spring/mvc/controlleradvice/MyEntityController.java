package bcntec.spring.mvc.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Controller
@RequestMapping("/")
public class MyEntityController {


    @ResponseBody
    @RequestMapping(value = "/{i}",
            produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> find(@PathVariable(name = "i") Integer pk) {
        //return myService.find(pk);
        switch (pk) {
            case 0:
            case 1:
                return ResponseEntity.status(pk == 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT).body("{\"my-entity\":{ \"pk\":\"" + pk + "\"}}");

            case 2:

                throw new MyEntityNotFoundException();
            default:
                throw new IllegalArgumentException("no es el parametro correcto");


        }
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/2/{i}",
            produces = APPLICATION_JSON_UTF8_VALUE)
    public String find2(@PathVariable(name = "i") Integer pk) {
        //return myService.find(pk);
        switch (pk) {
            case 1:
                return "{\"my-entity\":{ \"pk\":\"" + pk + "\"}}";

            case 2:

                throw new MyEntityNotFoundException();
            default:
                throw new IllegalArgumentException("no es el parametro correcto");


        }


    }


}

