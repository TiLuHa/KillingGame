package iz.netzwerk.src.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import iz.netzwerk.src.Model.Game;


public interface GameRepository extends CrudRepository<Game, Long>{
	@Query(
		value = "SELECT * FROM GAME WHERE NAME = ?1", 
		nativeQuery = true
	)
	Optional<Game> findByName(String name);
}
