package iz.netzwerk.src.Model;

import javax.persistence.*;

@Entity
public class Game {
	@Id
	@GeneratedValue
	private Long Id;
	
	@OneToOne
	KillingMethodSet killingMethods;
}
