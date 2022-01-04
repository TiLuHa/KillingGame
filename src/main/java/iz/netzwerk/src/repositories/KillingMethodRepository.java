package iz.netzwerk.src.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import iz.netzwerk.src.Model.KillingMethod;

public interface KillingMethodRepository extends CrudRepository<KillingMethod, Long>{
	@Query(
	  value = "SELECT * FROM KillingMethod WHERE LOGIN_NAME = ?1", 
	  nativeQuery = true
	)
	Optional<KillingMethod> findByName(String name);
}
