package bcntec.spring.data.entities;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author francisco.philip@gmail.com
 */

@Entity
@Table(name = "PRICES")
public class Price2Entity {
    @EmbeddedId
    private PricePKEmbedded pk;

    @Column
    private BigDecimal value;

    public PricePKEmbedded getPk() {
        return pk;
    }

    public void setPk(PricePKEmbedded pk) {
        this.pk = pk;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
