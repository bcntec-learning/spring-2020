package bcntec.spring.data.c_jpa_rest_repository;

import bcntec.spring.data.entities.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

}
