package iz.netwerk.src.Model;

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
	private boolean gameUnique;
}
