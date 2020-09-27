package bcntec.spring.mvc.viewresolvers;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public abstract class MyViews implements View {

    @Override
    public String getContentType() {
        return MediaType.TEXT_PLAIN_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        try (PrintWriter pw = new PrintWriter(response.getOutputStream())) {
            for (String k : model.keySet()) {
                pw.println(k + ":" + model.get(k));
            }
            pw.flush();
        }


    }

}