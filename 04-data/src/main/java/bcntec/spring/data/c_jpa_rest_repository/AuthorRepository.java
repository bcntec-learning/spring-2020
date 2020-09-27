package bcntec.spring.data.c_jpa_rest_repository;

import bcntec.spring.data.entities.AuthorEntity;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

}
