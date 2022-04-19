package iz.netzwerk.src.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import iz.netzwerk.src.Model.AccountGamePlayerMapping;

public interface AccountGamePlayerRepository extends CrudRepository<AccountGamePlayerMapping, Serializable>{
	@Query(
			value = "SELECT * FROM ACCOUNT_GAME_PLAYER_MAPPING WHERE ACC_ID = ?1", 
			nativeQuery = true
	)
	List<AccountGamePlayerMapping> getEntriesByAccount(Long id);
	
	@Query(
			value = "SELECT PLAYER_ID FROM ACCOUNT_GAME_PLAYER_MAPPING WHERE ACC_ID = ?1 AND GAME_ID = ?2", 
			nativeQuery = true
	)
	Long getPlayerIdByAccountAndGame(Long aId, Long gId);

	@Query(
			value = "SELECT * FROM ACCOUNT_GAME_PLAYER_MAPPING WHERE GAME_ID = ?1", 
			nativeQuery = true
	)
	List<AccountGamePlayerMapping> getEntriesByGame(Long gId);
	
	@Query(
			value = "SELECT PLAYER_ID FROM ACCOUNT_GAME_PLAYER_MAPPING WHERE GAME_ID = ?1", 
			nativeQuery = true
	)
	List<Long> getPlayerIdsOfGame(Long id);
	
	@Query(
			value = "SELECT ACC_ID FROM ACCOUNT_GAME_PLAYER_MAPPING WHERE GAME_ID = ?1", 
			nativeQuery = true
	)
	List<Long> getAccountIdsOfGame(Long id);
	
	@Query(
			value = "SELECT PLAYER_ID FROM ACCOUNT_GAME_PLAYER_MAPPING WHERE GAME_ID = ?1 AND IS_ADMIN = 1", 
			nativeQuery = true
	)
	List<Long> getLeaderIdsOfGame(Long gId);
	
	
}
