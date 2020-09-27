package bcntec.spring.mvc.binder.sample1;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;

/**
 *
 */
@Component
public class WebBindings {

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(MyEnum.class,
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(final String text) throws IllegalArgumentException {
                        setValue(MyEnum.valueOf(text.trim().toLowerCase()));
                    }
                });

    }


}
