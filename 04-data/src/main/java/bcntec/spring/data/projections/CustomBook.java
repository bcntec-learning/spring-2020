package bcntec.spring.data.projections;

import bcntec.spring.data.entities.AuthorEntity;
import bcntec.spring.data.entities.BookEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;


@Projection(name = "customBook", types = {BookEntity.class})
public interface CustomBook {
    @Value("#{target.id}")
    long getId();

    String getTitle();

    List<AuthorEntity> getAuthors();

    @Value("#{target.getAuthors().size()}")
    int getAuthorCount();
}
