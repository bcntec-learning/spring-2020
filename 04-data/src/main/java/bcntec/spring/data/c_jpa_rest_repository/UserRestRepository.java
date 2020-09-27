package bcntec.spring.data.c_jpa_rest_repository;

import bcntec.spring.data.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRestRepository extends CrudRepository<UserEntity, Long> {

    @Override
    @RestResource(exported = false)
    void delete(UserEntity entity);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends UserEntity> entities);

    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);

    @RestResource(path = "byEmail", rel = "customFindMethod")
    UserEntity findByEmail(@Param("email") String email);
}
