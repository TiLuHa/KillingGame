package iz.netzwerk.src.Model;

import javax.persistence.*;

@Entity
public class KillingMethod {
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(
	  nullable = false
	, unique = true
	)
	public String description;
	
	@Column
	private boolean globalVisible;
	
	@Column
	private boolean gameUnique;
}
