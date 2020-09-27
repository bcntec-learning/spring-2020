package bcntec.spring.data.entities;


import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author francisco.philip@gmail.com
 */

@Entity
@Table(name = "PRICES")
@IdClass(PricePK.class)
public class PriceEntity {
    @Id
    @ManyToOne
    private BookEntity book;

    @Id
    @ManyToOne
    private LibraryEntity library;

    @Column
    private BigDecimal value;

}
