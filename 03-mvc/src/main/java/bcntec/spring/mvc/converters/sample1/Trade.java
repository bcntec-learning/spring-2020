package bcntec.spring.mvc.converters.sample1;


import java.math.BigDecimal;

public class Trade {

    private Long id;
    private Type type;
    private BigDecimal value;


    public Trade(Long id, Type type, BigDecimal value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public enum Type {
        BUY, SELL
    }
}