package iz.netwerk.src.Model;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
class AccountGame implements Serializable{
	@OneToOne
    public Account acc;
	
	@OneToOne
    public Game game;
}

@Entity
public class AccountGamePlayerMapping {
	@EmbeddedId
	private AccountGame Id;

//	@Id
//	@OneToOne
//	public Account acc;
//	@Id
//	@OneToOne
//	public Game game;
	@OneToOne
	public Player player;
}
