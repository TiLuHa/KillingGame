package iz.netzwerk.src.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Game {
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany
	private List<GameKillingMethod> killingMethods;
	
	@Column
	private Date startsAt;
	
	@Column
	private Date endsAt;
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@ManyToOne(optional = false)
	private Account creator;

	public Game(String name, String code, Account creator)
	{
		this.killingMethods = new ArrayList<>();
		this.name = name;
		this.code = code;
		this.creator = creator;
	}
	
	public Game()
	{
		this.killingMethods = new ArrayList<>();
	}
	
	public Long getId()
	{
		return this.Id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public List<GameKillingMethod> getKillingMethods ()
	{
		return this.killingMethods;
	}
	
	public Date getStartTime()
	{
		return this.startsAt;
	}
	
	public Date getEndTime()
	{
		return this.endsAt;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public Account getCreator()
	{
		return creator;
	}
}
