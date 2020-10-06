package bcntec.spring.mvc.converters.map;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Location {
    private BigDecimal lat;
    private BigDecimal lon;
    private BigDecimal z;

    public Location(String path) {
        String[] d = path.split(":");
        lat = new BigDecimal(d[0]);
        lon = new BigDecimal(d[1]);
        z = new BigDecimal(d[2]);
    }
}
