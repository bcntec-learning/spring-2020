package bcntec.spring.data.b_jpa_repository;

import bcntec.spring.data.entities.PriceEntity;
import bcntec.spring.data.entities.PricePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, PricePK> {

}
