package bcntec.spring.data.entities;


import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author francisco.philip@gmail.com
 */

public class PricePKEmbedded implements Serializable {
    @ManyToOne
    private BookEntity book;


    @ManyToOne
    private LibraryEntity library;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricePKEmbedded pricePK = (PricePKEmbedded) o;
        return Objects.equals(book, pricePK.book) &&
                Objects.equals(library, pricePK.library);
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public LibraryEntity getLibrary() {
        return library;
    }

    public void setLibrary(LibraryEntity library) {
        this.library = library;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, library);
    }
}
