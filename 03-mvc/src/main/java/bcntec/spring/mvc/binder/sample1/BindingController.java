package bcntec.spring.mvc.binder.sample1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.PropertyEditorSupport;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@Controller
@RequestMapping("/")
public class BindingController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(MyEnum.class,
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(final String text) throws IllegalArgumentException {
                        setValue(MyEnum.valueOf(text.trim().toUpperCase()));
                    }
                });

    }

    @ResponseBody
    @RequestMapping(value = "/{enum}/text",
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MyEnum> find(@PathVariable(name = "enum") String text) {
        MyEnum myEnum = MyEnum.valueOf(text.trim().toUpperCase());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(myEnum);
    }



    @ResponseBody
    @RequestMapping(value = "/{enum}",
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MyEnum> find(@PathVariable(name = "enum") MyEnum myEnum) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(myEnum);
    }

    @ResponseBody
    @RequestMapping(value = "/{enum}",
            produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<MyEnum> find2(@PathVariable(name = "enum") MyEnum myEnum) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(myEnum);


    }

}
