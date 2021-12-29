package iz.netwerk.src.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column( 
	  unique = true 
	, nullable = false
	)
	private String loginName;
	
	@Column (nullable = false)
	private String password;
	
	@Column(
	  unique = true
	, nullable = false
	)
	private String email;
	
	@ElementCollection
	private List<AccountFlags> flags;
	
	@ElementCollection
	private List<AccountRoles> roles;
	
	public Account() {
		this.roles = new ArrayList<>();
		this.flags = new ArrayList<>();
	}
	
	public Account(String loginName, String password, String email){
		this.loginName = loginName;
		this.password = password;
		this.email = email;
		this.roles = new ArrayList<>();
		this.flags = new ArrayList<>();
	}
	
	public Long getId()
	{
		return this.Id;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getLoginName()
	{
		return this.loginName;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public List<AccountFlags> getFlags()
	{
		return this.flags;
	}
	
	public List<AccountRoles> getRoles()
	{
		return this.roles;
	}
	
	public void addRole(AccountRoles ar) {
		this.roles.add(ar);
	}
}
