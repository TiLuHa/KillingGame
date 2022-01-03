package iz.netzwerk.src.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class KillingMethodSet {
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany
	private List<KillingMethod> methods;
}
