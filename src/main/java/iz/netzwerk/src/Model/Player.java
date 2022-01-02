package iz.netzwerk.src.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Player {
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(nullable = false)
	public String nickName;
	
	@OneToOne
	public Mission mission;
	
	@Column
	public Date missionRequestedAt;
	
	@Column
	public Date diedAt;
}
