package bcntec.spring.data.c_jpa_rest_repository;

import bcntec.spring.data.entities.BookEntity;
import bcntec.spring.data.projections.CustomBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(excerptProjection = CustomBook.class)
public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
