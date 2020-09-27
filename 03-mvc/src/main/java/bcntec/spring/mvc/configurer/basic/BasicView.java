package bcntec.spring.mvc.configurer.basic;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class BasicView extends InternalResourceView {

    @Override
    public String getContentType() {
        return MediaType.TEXT_PLAIN_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        StringBuilder b = new StringBuilder();
        model.entrySet().forEach(a -> {
            b.append(a.getKey() + "=" + a.getValue() + "\n");

        });

        response.getOutputStream().write(b.toString().getBytes());


    }


}
