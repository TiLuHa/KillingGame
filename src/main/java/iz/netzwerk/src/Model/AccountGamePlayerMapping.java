package iz.netzwerk.src.Model;

import javax.persistence.*;

@Entity
public class AccountGamePlayerMapping {
	@EmbeddedId
	public AccountGame Id;
	
	@OneToOne(optional = false)
	public Player player;
	
	@Column
	public boolean isAdmin = false;
	
	public AccountGamePlayerMapping(Account acc, Game game, Player player, boolean isAdmin){
		this.Id = new AccountGame(acc, game);
		this.player = player;
		this.isAdmin = isAdmin;
	}
	
	public AccountGamePlayerMapping() {}
}
