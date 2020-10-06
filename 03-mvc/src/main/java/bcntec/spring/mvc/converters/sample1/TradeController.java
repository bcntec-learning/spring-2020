package bcntec.spring.mvc.converters.sample1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping("/trades")
public class TradeController {


    @ResponseBody
    @RequestMapping(value = "/operation1", params = {"id", "type", "value"},
            produces = APPLICATION_JSON_VALUE)
    public Trade operation1(
            @RequestParam("id") String id,
            @RequestParam("type") String type,
            @RequestParam("value") String value
    ) {

        return new Trade(new Long(id), Trade.Type.valueOf(type), new BigDecimal(value));
    }

    @ResponseBody
    @RequestMapping(value = "/operation2", params = {"id", "type", "value"},
            produces = APPLICATION_JSON_VALUE)
    public Trade operation2(
            @RequestParam("id") Long id,
            @RequestParam("type") Trade.Type type,
            @RequestParam("value") BigDecimal value
    ) {

        return new Trade(id, type, value);
    }

    @ResponseBody
    @RequestMapping(value = "/", params = "operation",
            produces = APPLICATION_JSON_VALUE)
    public Trade handleTradeRequest(@RequestParam("operation") Trade trade) {

        return trade;
    }
}