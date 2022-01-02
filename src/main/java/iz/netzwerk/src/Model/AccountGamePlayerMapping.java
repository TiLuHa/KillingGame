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
}

@Entity
public class AccountGamePlayerMapping {
	@EmbeddedId
	private AccountGame Id;
	
	@OneToOne
	public Player player;
}
