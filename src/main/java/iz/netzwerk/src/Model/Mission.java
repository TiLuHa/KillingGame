package iz.netzwerk.src.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Mission {
	@Id
	@GeneratedValue
	private Long Id;

	@ManyToOne
	public Game g;

	@OneToOne
	public Player contractor;
	
	@OneToOne
	public Player target;
	
	@OneToOne
	public KillingMethod method;
	
	@Column(nullable = false)
	public MissionState state;
	
	@Column(nullable = false)
	public Date assignedAt;
	
	@Column
	public Date finalizedAt;
}
