package bcntec.spring.data.d_rest;

import bcntec.spring.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, PagingAndSortingRepository<UserEntity, Long> {


}
