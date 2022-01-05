package iz.netzwerk.src.repositories;

import org.springframework.data.repository.CrudRepository;

import iz.netzwerk.src.Model.Game;


public interface GameRepository extends CrudRepository<Game, Long>{
	
}
