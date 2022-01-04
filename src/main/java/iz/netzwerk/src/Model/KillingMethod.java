package iz.netzwerk.src.Model;

import javax.persistence.*;

@Entity
public class KillingMethod {
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(
	  nullable = false
	)
	private String description;
	
	@Column
	private boolean gameUnique;
	
	public KillingMethod()
	{
		this.description = "Not assigned";
		this.gameUnique = false;
	}
	
	public KillingMethod(String description, boolean gameUnique)
	{
		this.description = description;
		this.gameUnique = gameUnique;
	}
	
	public Long getId()
	{
		return this.Id;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public boolean getGameUniqunes()
	{
		return this.gameUnique;
	}
}
