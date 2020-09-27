package bcntec.spring.data.c_jpa_rest_repository;

import bcntec.spring.data.entities.SubjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface SubjectRepository extends PagingAndSortingRepository<SubjectEntity, Long> {

    @RestResource(path = "nameContains")
    public Page<SubjectEntity> findByNameContaining(@Param("name") String name, Pageable p);

}