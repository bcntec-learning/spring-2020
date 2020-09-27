package bcntec.spring.data.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author francisco.philip@gmail.com
 */

public class PricePK implements Serializable {

    private BookEntity book;

    private LibraryEntity library;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricePK pricePK = (PricePK) o;
        return Objects.equals(book, pricePK.book) &&
                Objects.equals(library, pricePK.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, library);
    }
}
