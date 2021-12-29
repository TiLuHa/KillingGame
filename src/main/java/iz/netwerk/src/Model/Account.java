package iz.netwerk.src.Model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Account {
	@Id
	@GeneratedValue
	public Long Id;
	
	@Column( 
	  unique = true 
	, nullable = false
	)
	public String loginName;
	
	@Column (nullable = false)
	public String password;
	
	@Column(
	  unique = true
	, nullable = false
	)
	public String email;
	
	@ElementCollection
	public List<AccountFlags> flags;
}
