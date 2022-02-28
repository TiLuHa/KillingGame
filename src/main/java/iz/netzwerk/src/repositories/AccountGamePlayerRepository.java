package iz.netzwerk.src.repositories;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import iz.netzwerk.src.Model.AccountGamePlayerMapping;

public interface AccountGamePlayerRepository extends CrudRepository<AccountGamePlayerMapping, Serializable>{

}
