package albacorn.albacorn.repository;

import albacorn.albacorn.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
