package iz.netzwerk.src.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import iz.netzwerk.src.Model.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{
	@Query(
	  value = "SELECT * FROM Account WHERE LOGIN_NAME = ?1", 
	  nativeQuery = true
	)
	Optional<Account> findByName(String name);
	
	@Query(
	  value = "SELECT * FROM Account WHERE EMAIL = ?1", 
	  nativeQuery = true
	)
	Optional<Account> findByEmail(String email);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(
	  value = "update Account a set a.password = ? where a.Id = ?",
	  nativeQuery = true
	)
	int updatePassword(String pw, Long Id);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(
	  value = "update Account a set a.login_name = ? where a.Id = ?",
	  nativeQuery = true
	)
	int updateLoginName(String loginName, Long Id);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(
	  value = "update Account a set a.email = ? where a.Id = ?",
	  nativeQuery = true
	)
	int updateEmail(String email, Long Id);
	
}
