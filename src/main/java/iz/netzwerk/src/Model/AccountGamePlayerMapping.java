package iz.netzwerk.src.Model;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
class AccountGame implements Serializable{
	private static final long serialVersionUID = 1L;

	@OneToOne
    public Account acc;
	
	@OneToOne
    public Game game;
	
	public AccountGame(Account acc, Game game) {
		this.acc = acc;
		this.game = game;
	}
	
	public AccountGame() {}
}

@Entity
public class AccountGamePlayerMapping {
	@EmbeddedId
	public AccountGame Id;
	
	@OneToOne
	public Player player;
	
	@Column
	public boolean isAdmin;
	
	public AccountGamePlayerMapping(Account acc, Game game, Player player, boolean isAdmin){
		this.Id = new AccountGame(acc, game);
		this.player = player;
		this.isAdmin = isAdmin;
	}
	
	public AccountGamePlayerMapping() {}
}
