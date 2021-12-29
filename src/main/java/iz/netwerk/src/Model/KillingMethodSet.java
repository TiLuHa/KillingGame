package iz.netwerk.src.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class KillingMethodSet {
	@Id
	@GeneratedValue
	private Long Id;
	
	@OneToMany
	private List<KillingMethod> methods;
}
