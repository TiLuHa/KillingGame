package iz.netzwerk.src.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

@Embeddable
class MethodId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column
	@GeneratedValue
	public Long id;

	@OneToOne
	public Game game;
}

@Entity
public class GameKillingMethod {

	@EmbeddedId
	private MethodId id;

	@Column(nullable = false)
	private String description;

	@Column
	private boolean gameUnique;

	@Column
	private boolean used;
	
	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public GameKillingMethod() {
		this.description = "Not assigned";
		this.gameUnique = false;
	}

	public GameKillingMethod(Game game, String description, boolean gameUnique) {
		this.description = description;
		this.gameUnique = gameUnique;
		this.id.game = game;
	}

	public MethodId getId() {
		return this.id;
	}

	public String getDescription() {
		return this.description;
	}

	public boolean getGameUniqunes() {
		return this.gameUnique;
	}
}
