package iz.netzwerk.src.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Embeddable
class MethodId implements Serializable{
	private static final long serialVersionUID = 1L;

	@OneToOne
    public KillingMethod method;
}

@Entity
public class GameKillingMethod {
	
	@EmbeddedId
	private MethodId method;
	
	@Column
	private boolean oneTime;
	
	@Column
	private boolean used;
}
