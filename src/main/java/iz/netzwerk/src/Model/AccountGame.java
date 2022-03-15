package iz.netzwerk.src.Model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class AccountGame implements Serializable{
	private static final long serialVersionUID = 1L;

	@OneToOne(optional = false)
    public Account acc;
	
	@OneToOne(optional = false)
    public Game game;
	
	public AccountGame(Account acc, Game game) {
		this.acc = acc;
		this.game = game;
	}
	
	public AccountGame() {}
}
