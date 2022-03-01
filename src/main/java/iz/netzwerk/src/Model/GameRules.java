package iz.netzwerk.src.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GameRules {
	@GeneratedValue
	@Id
	private Long Id;
	
	@Column(nullable = false)
	private String name;
}
