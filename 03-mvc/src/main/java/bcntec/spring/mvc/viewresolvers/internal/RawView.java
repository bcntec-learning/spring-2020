package bcntec.spring.mvc.viewresolvers.internal;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Map;

public class RawView extends InternalResourceView {

    @Override
    public String getContentType() {
        return MediaType.TEXT_PLAIN_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {


        InputStream is = new ClassPathResource("/META-INF/resources" + getUrl()).getInputStream();

        StreamUtils.copy(is, response.getOutputStream());


    }


}
