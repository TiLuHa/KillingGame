package iz.netzwerk.src.Model;

import javax.persistence.*;

@Embeddable
public class GameRules {
	@GeneratedValue
	@Id
	private Long Id;
	
	@Column(nullable = false)
	private String name;
}
