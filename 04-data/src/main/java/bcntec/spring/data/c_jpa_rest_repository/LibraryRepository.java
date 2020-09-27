package bcntec.spring.data.c_jpa_rest_repository;

import bcntec.spring.data.entities.LibraryEntity;
import org.springframework.data.repository.CrudRepository;


public interface LibraryRepository extends CrudRepository<LibraryEntity, Long> {

}
