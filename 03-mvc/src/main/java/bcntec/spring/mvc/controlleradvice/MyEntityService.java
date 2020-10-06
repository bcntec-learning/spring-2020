package bcntec.spring.mvc.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MyEntityService {

    public String process(Integer pk){
        switch (pk) {
            case 0:
            case 1:
                return ("{\"my-entity\":{ \"pk\":\"" + pk + "\"}}");
            case 2:
                throw new MyEntityNotFoundException();
            case 3:
                throw new NullPointerException();
            default:
                throw new IllegalArgumentException("no es el parametro correcto");


        }
    }
}
