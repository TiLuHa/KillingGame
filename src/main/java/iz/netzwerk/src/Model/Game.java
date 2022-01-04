package iz.netzwerk.src.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Game {
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany
	private List<GameKillingMethod> killingMethods;
	
	@Column
	private Date startsAt;
	
	@Column
	private Date endsAt;
}
