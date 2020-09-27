package bcntec.spring.data.b_jpa_repository;

import bcntec.spring.data.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByOrderByNameAsc();

    @Query(value = "from User order by name")
    List<UserEntity> listMyOrder();

    @Query("select u.name from User u group by u.name order by u.name")
    List<String> listNames();

    Page<UserEntity> findAllByNameLikeOrderByNameAsc(String name, Pageable page);


    @Query(value = "from User where name like :name order by name",
            countQuery = "select count(u) from User u where u.name like :name ")
        //?1
    Page<UserEntity> listMyOrder(@Param("name") String name, Pageable page);

    default List<String> names(EntityManager e) {

        return new ArrayList<>();
    }
}
