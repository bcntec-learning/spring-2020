package bcntec.spring.mvc.viewresolvers;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("pdf")
public class MyPDF extends AbstractPdfView {


    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        Table table = new Table(2);
        table.addCell("Key");
        table.addCell("Value");
        for (String k : model.keySet()) {
            table.addCell(k);
            table.addCell(model.containsKey(k) ? model.get(k).toString() : "<empty>");
        }


        document.add(table);
    }
}